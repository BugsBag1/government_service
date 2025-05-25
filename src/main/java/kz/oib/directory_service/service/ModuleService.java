package kz.oib.directory_service.service;

import kz.oib.directory_service.local.IModuleService;
import kz.oib.directory_service.model.dto.ModuleRequestDTO;
import kz.oib.directory_service.model.dto.ModuleResponseDTO;
import kz.oib.directory_service.model.entity.ModuleEntity;
import kz.oib.directory_service.model.repo.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService implements IModuleService {

    private final ModuleRepository repository;

    @Override
    public ModuleResponseDTO create(ModuleRequestDTO requestDTO) {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setNameRu(requestDTO.getNameRu());
        moduleEntity.setNameKz(requestDTO.getNameKz());
        moduleEntity.setDescriptionRu(requestDTO.getDescriptionRu());
        moduleEntity.setDescriptionKz(requestDTO.getDescriptionKz());
        ModuleEntity savedEntity = repository.save(moduleEntity);
        return mapToResponse(savedEntity);
    }

    @Override
    public ModuleResponseDTO update(Long id, ModuleRequestDTO requestDTO) {
        ModuleEntity entity = repository.findById(id).get();
        if (entity != null) {
            entity.setNameRu(requestDTO.getNameRu());
            entity.setNameKz(requestDTO.getNameKz());
            entity.setDescriptionRu(requestDTO.getDescriptionRu());
            entity.setDescriptionKz(requestDTO.getDescriptionKz());
            entity = repository.save(entity);
            return mapToResponse(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ModuleResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModuleResponseDTO> getActual() {
        return repository.findByIsDeletedFalse().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ModuleResponseDTO mapToResponse(ModuleEntity entity) {
        ModuleResponseDTO moduleResponseDTO = new ModuleResponseDTO();
        moduleResponseDTO.setId(entity.getId());
        moduleResponseDTO.setNameRu(entity.getNameRu());
        moduleResponseDTO.setNameKz(entity.getNameKz());
        moduleResponseDTO.setDescriptionRu(entity.getDescriptionRu());
        moduleResponseDTO.setDescriptionKz(entity.getDescriptionKz());
        return moduleResponseDTO;
    }
}
