package kz.oib.directory_service.model.repo;

import kz.oib.directory_service.model.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
    List<ModuleEntity> findByIsDeletedFalse();
}
