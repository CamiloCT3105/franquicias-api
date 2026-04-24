package franquicias_api.controller;

import franquicias_api.model.Product;
import franquicias_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import franquicias_api.dto.UpdateStockRequest;
import jakarta.validation.Valid;
import franquicias_api.dto.UpdateNameRequest;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/branch/{branchId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(
            @PathVariable Long branchId,
            @RequestBody Product product
    ) {
        return productService.addProduct(branchId, product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PatchMapping("/{productId}/stock")
    public Product updateStock(
            @PathVariable Long productId,
            @Valid @RequestBody UpdateStockRequest request
    ) {
        return productService.updateStock(productId, request.getStock());
    }

    @PatchMapping("/{productId}/name")
    public Product updateProductName(
            @PathVariable Long productId,
            @Valid @RequestBody UpdateNameRequest request
    ) {
        return productService.updateProductName(
                productId,
                request.getName()
        );
    }
}