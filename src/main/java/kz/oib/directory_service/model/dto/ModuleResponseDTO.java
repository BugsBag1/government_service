package kz.oib.directory_service.model.dto;

import lombok.Data;

@Data
public class ModuleResponseDTO {
    private Long id;
    private String nameRu;
    private String nameKz;
    private String descriptionRu;
    private String descriptionKz;
}
