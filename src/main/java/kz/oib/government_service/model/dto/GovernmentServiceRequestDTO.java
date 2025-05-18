package kz.oib.government_service.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GovernmentServiceRequestDTO {
    @NotBlank(message = "Название на русском обязателен")
    private String nameRu;

    @NotBlank(message = "Название на казахском обязательно")
    private String nameKz;

}
