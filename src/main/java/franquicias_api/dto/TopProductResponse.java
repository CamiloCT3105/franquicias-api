package franquicias_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopProductResponse {

    private String branchName;
    private String productName;
    private Integer stock;
}