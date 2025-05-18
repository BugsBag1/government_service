package kz.oib.government_service.local;

import kz.oib.government_service.model.dto.GovernmentServiceRequestDTO;
import kz.oib.government_service.model.dto.GovernmentServiceResponseDTO;
import kz.oib.government_service.model.entity.GovernmentEntity;

import java.util.List;

public interface IGovernmentService {
    GovernmentServiceResponseDTO create(GovernmentServiceRequestDTO government);
    GovernmentServiceResponseDTO update(Long id, GovernmentServiceRequestDTO government);
    void delete(Long id);
    List<GovernmentServiceResponseDTO> getAll();
}
