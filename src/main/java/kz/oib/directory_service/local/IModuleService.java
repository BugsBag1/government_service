package kz.oib.directory_service.local;


import kz.oib.directory_service.model.dto.ModuleRequestDTO;
import kz.oib.directory_service.model.dto.ModuleResponseDTO;

import java.util.List;

public interface IModuleService {
    ModuleResponseDTO create(ModuleRequestDTO government);
    ModuleResponseDTO update(Long id, ModuleRequestDTO government);
    void delete(Long id);
    List<ModuleResponseDTO> getAll();
    List<ModuleResponseDTO> getActual();
}
