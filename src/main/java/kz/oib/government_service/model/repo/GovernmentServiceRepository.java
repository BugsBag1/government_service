package kz.oib.government_service.model.repo;

import kz.oib.government_service.model.entity.GovernmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GovernmentServiceRepository extends JpaRepository<GovernmentEntity, Long> {
    List<GovernmentEntity> findByIsDeletedFalse();
}
