package franquicias_api.service;

import franquicias_api.model.Franchise;
import franquicias_api.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import franquicias_api.model.Branch;
import jakarta.persistence.EntityNotFoundException;
import franquicias_api.dto.TopProductResponse;
import franquicias_api.model.Product;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Branch addBranch(Long franchiseId, Branch branch) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        branch.setFranchise(franchise);
        franchise.getBranches().add(branch);

        franchiseRepository.save(franchise);

        return branch;
    }

    public List<TopProductResponse> getTopProductsByFranchise(Long franchiseId) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        return franchise.getBranches()
                .stream()
                .filter(branch -> !branch.getProducts().isEmpty())
                .map(branch -> {
                    Product topProduct = branch.getProducts()
                            .stream()
                            .max(Comparator.comparing(Product::getStock))
                            .orElseThrow();

                    return new TopProductResponse(
                            branch.getName(),
                            topProduct.getName(),
                            topProduct.getStock()
                    );
                })
                .toList();
    }

    public Franchise updateFranchiseName(Long franchiseId, String name) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        franchise.setName(name);

        return franchiseRepository.save(franchise);
    }
}


