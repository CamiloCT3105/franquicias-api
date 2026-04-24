package franquicias_api.controller;

import franquicias_api.model.Franchise;
import franquicias_api.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import franquicias_api.model.Branch;
import franquicias_api.dto.TopProductResponse;
import java.util.List;
import franquicias_api.dto.UpdateNameRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService franchiseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.createFranchise(franchise);
    }

    @PostMapping("/{franchiseId}/branches")
    @ResponseStatus(HttpStatus.CREATED)
    public Branch addBranch(
            @PathVariable Long franchiseId,
            @RequestBody Branch branch
    ) {
        return franchiseService.addBranch(franchiseId, branch);
    }

    @GetMapping("/{franchiseId}/top-products")
    public List<TopProductResponse> getTopProducts(
            @PathVariable Long franchiseId
    ) {
        return franchiseService.getTopProductsByFranchise(franchiseId);
    }

    @PatchMapping("/{franchiseId}/name")
    public Franchise updateFranchiseName(
            @PathVariable Long franchiseId,
            @Valid @RequestBody UpdateNameRequest request
    ) {
        return franchiseService.updateFranchiseName(
                franchiseId,
                request.getName()
        );
    }
}

