package dev.eyaz.exmpl.service.write.converter;

import dev.eyaz.exmpl.service.write.dto.response.OperationCreateResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.write.model.ObjectEntity;
import dev.eyaz.exmpl.service.write.model.OperationEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {

    public ResponseConverter() {
    }

    public OperationCreateResponse entityToCreateDto(OperationEntity entity) {
        OperationCreateResponse response = new OperationCreateResponse();

        response.setCreationTime(entity.getCreated_at());
        response.setLink(entity.getLink());

        return response;
    }

    public OperationReadResponse entityToReadDto(OperationEntity entity, ObjectEntity object) {
        OperationReadResponse response = new OperationReadResponse();
        response.setExpiration(entity.getExpiration());
        response.setCreationTime(entity.getCreated_at().toString());
        response.setMessage(object.getMessage());

        return response;
    }
}
