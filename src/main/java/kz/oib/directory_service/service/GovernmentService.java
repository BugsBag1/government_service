package kz.oib.directory_service.service;

import kz.oib.directory_service.local.IGovernmentService;
import kz.oib.directory_service.model.dto.GovernmentServiceRequestDTO;
import kz.oib.directory_service.model.dto.GovernmentServiceResponseDTO;
import kz.oib.directory_service.model.entity.GovernmentEntity;
import kz.oib.directory_service.model.repo.GovernmentServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GovernmentService implements IGovernmentService {
    private final GovernmentServiceRepository repository;

    @Override
    public GovernmentServiceResponseDTO create(GovernmentServiceRequestDTO requestDTO) {
        GovernmentEntity entity = new GovernmentEntity();
        entity.setNameRu(requestDTO.getNameRu());
        entity.setNameKz(requestDTO.getNameKz());
        GovernmentEntity savedEntity = repository.save(entity);
        return mapToResponse(savedEntity);
    }

    @Override
    public GovernmentServiceResponseDTO update(Long id, GovernmentServiceRequestDTO requestDTO) {
        GovernmentEntity entity = repository.findById(id).get();
        if (entity != null) {
            entity.setNameRu(requestDTO.getNameRu());
            entity.setNameKz(requestDTO.getNameKz());
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
    public List<GovernmentServiceResponseDTO> getAll(){
        return repository.findByIsDeletedFalse().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private GovernmentServiceResponseDTO mapToResponse(GovernmentEntity entity) {
        return new GovernmentServiceResponseDTO(
                entity.getId(),
                entity.getNameRu(),
                entity.getNameKz(),
                entity.getIsDeleted()
        );
    }
}
