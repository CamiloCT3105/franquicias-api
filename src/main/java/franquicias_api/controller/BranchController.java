package franquicias_api.controller;

import franquicias_api.dto.UpdateNameRequest;
import franquicias_api.model.Branch;
import franquicias_api.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PatchMapping("/{branchId}/name")
    public Branch updateBranchName(
            @PathVariable Long branchId,
            @Valid @RequestBody UpdateNameRequest request
    ) {
        return branchService.updateBranchName(
                branchId,
                request.getName()
        );
    }
}