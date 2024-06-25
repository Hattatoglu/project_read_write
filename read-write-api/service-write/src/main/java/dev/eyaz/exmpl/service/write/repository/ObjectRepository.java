package dev.eyaz.exmpl.service.write.repository;

import dev.eyaz.exmpl.service.write.model.ObjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjectRepository extends MongoRepository<ObjectEntity, String> {
}
