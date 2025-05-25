package kz.oib.directory_service.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "module_table")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;
    @Column(name = "name_kz")
    private String nameKz;
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
    @Column(name = "description_ru")
    private String descriptionRu;
    @Column(name = "description_kz")
    private String descriptionKz;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "upated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }



}
