package kz.oib.directory_service.local;

import kz.oib.directory_service.model.dto.GovernmentServiceRequestDTO;
import kz.oib.directory_service.model.dto.GovernmentServiceResponseDTO;

import java.util.List;

public interface IGovernmentService {
    GovernmentServiceResponseDTO create(GovernmentServiceRequestDTO government);
    GovernmentServiceResponseDTO update(Long id, GovernmentServiceRequestDTO government);
    void delete(Long id);
    List<GovernmentServiceResponseDTO> getAll();
}
