package franquicias_api.service;

import franquicias_api.model.Branch;
import franquicias_api.model.Product;
import franquicias_api.repository.BranchRepository;
import franquicias_api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public Product addProduct(Long branchId, Product product) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada"));

        product.setBranch(branch);

        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Producto no encontrado");
        }

        productRepository.deleteById(productId);
    }

    public Product updateStock(Long productId, Integer stock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        product.setStock(stock);

        return productRepository.save(product);
    }

    public Product updateProductName(Long productId, String name) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        product.setName(name);

        return productRepository.save(product);
    }
}