package franquicias_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNameRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
}