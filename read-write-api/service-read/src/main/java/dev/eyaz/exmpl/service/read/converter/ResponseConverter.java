package dev.eyaz.exmpl.service.read.converter;

import dev.eyaz.exmpl.service.read.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.read.model.ObjectEntity;
import dev.eyaz.exmpl.service.read.model.OperationEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {

    public ResponseConverter() {
    }

    public OperationReadResponse entityToReadDto(OperationEntity entity, ObjectEntity object) {
        OperationReadResponse response = new OperationReadResponse();
        response.setExpiration(entity.getExpiration());
        response.setCreationTime(entity.getCreated_at().toString());
        response.setMessage(object.getMessage());

        return response;
    }
}
