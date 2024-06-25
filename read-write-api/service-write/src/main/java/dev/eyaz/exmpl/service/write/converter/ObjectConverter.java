package dev.eyaz.exmpl.service.write.converter;

import dev.eyaz.exmpl.service.write.dto.request.OperationCreateRequest;
import dev.eyaz.exmpl.service.write.model.ObjectEntity;
import dev.eyaz.exmpl.service.write.model.OperationEntity;
import org.springframework.stereotype.Component;

@Component
public class ObjectConverter {

    public ObjectEntity entityToObject(OperationEntity entity, OperationCreateRequest request) {
        ObjectEntity objectEntity = new ObjectEntity();
        objectEntity.setLink(entity.getLink());
        objectEntity.setMessage(request.getMessage());

        return objectEntity;
    }
}
