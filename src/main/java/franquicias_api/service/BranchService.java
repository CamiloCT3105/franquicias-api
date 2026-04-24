package franquicias_api.service;

import franquicias_api.model.Branch;
import franquicias_api.repository.BranchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public Branch updateBranchName(Long branchId, String name) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada"));

        branch.setName(name);

        return branchRepository.save(branch);
    }
}