package dev.eyaz.exmpl.service.read.repository;

import dev.eyaz.exmpl.service.read.model.ObjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjectRepository extends MongoRepository<ObjectEntity, String> {
}
