package dev.eyaz.exmpl.service.write.repository;

import dev.eyaz.exmpl.service.write.model.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    Optional<OperationEntity> findByLink(String link);
}
