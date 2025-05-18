package kz.oib.government_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GovernmentServiceResponseDTO {
    private Long id;
    private String nameRu;
    private String nameKz;
    private boolean isDeleted;


}
