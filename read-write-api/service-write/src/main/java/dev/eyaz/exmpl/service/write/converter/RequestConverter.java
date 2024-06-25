package dev.eyaz.exmpl.service.write.converter;

import dev.eyaz.exmpl.service.write.dto.request.OperationCreateRequest;
import dev.eyaz.exmpl.service.write.model.OperationEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RequestConverter {
    public RequestConverter() {
    }

    public OperationEntity createToEntity(OperationCreateRequest request) {
        OperationEntity entity = new OperationEntity();

        entity.setCreated_at(LocalDateTime.now());
        entity.setExpiration(request.getExpiration());

        return entity;
    }
}
