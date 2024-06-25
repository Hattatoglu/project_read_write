package dev.eyaz.exmpl.service.write.service;

import dev.eyaz.exmpl.service.write.converter.ObjectConverter;
import dev.eyaz.exmpl.service.write.converter.RequestConverter;
import dev.eyaz.exmpl.service.write.converter.ResponseConverter;
import dev.eyaz.exmpl.service.write.dto.request.OperationDeleteRequest;
import dev.eyaz.exmpl.service.write.dto.request.OperationReadRequest;
import dev.eyaz.exmpl.service.write.dto.request.OperationUpdateRequest;
import dev.eyaz.exmpl.service.write.dto.response.OperationDeleteResponse;
import dev.eyaz.exmpl.service.write.dto.request.OperationCreateRequest;
import dev.eyaz.exmpl.service.write.dto.response.OperationCreateResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationUpdateResponse;
import dev.eyaz.exmpl.service.write.exception.LinkNotFoundException;
import dev.eyaz.exmpl.service.write.generator.LinkGenerator;
import dev.eyaz.exmpl.service.write.model.ObjectEntity;
import dev.eyaz.exmpl.service.write.model.OperationEntity;
import dev.eyaz.exmpl.service.write.repository.ObjectRepository;
import dev.eyaz.exmpl.service.write.repository.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WriteService {

    private final OperationRepository repository;
    private final ObjectRepository objectRepository;
    private final RequestConverter requestConverter;
    private final ResponseConverter responseConverter;
    private final LinkGenerator linkGenerator;
    private final ObjectConverter objectConverter;

    public WriteService(OperationRepository repository, ObjectRepository objectRepository,
                        RequestConverter requestConverter, ResponseConverter responseConverter,
                        LinkGenerator linkGenerator, ObjectConverter objectConverter) {
        this.repository = repository;
        this.objectRepository = objectRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
        this.linkGenerator = linkGenerator;
        this.objectConverter = objectConverter;
    }

    @Transactional
    public OperationCreateResponse save(OperationCreateRequest request) {

        OperationEntity entity = requestConverter.createToEntity(request);
        entity.setLink(linkGenerator.generateLink(request, entity));

        ObjectEntity objectEntity = objectConverter.entityToObject(entity, request);
        entity = repository.save(entity);
        objectRepository.save(objectEntity);

        return responseConverter.entityToCreateDto(entity);
    }

    public OperationDeleteResponse deleteOperation(OperationDeleteRequest request) {
        Optional<OperationEntity> entity = repository.findByLink(request.getLink());

        repository.delete(entity.get());

        OperationDeleteResponse response = new OperationDeleteResponse();
        response.setMessage("link deleted...");

        return response;
    }

    public OperationUpdateResponse updateOperation(OperationUpdateRequest request) {
        OperationUpdateResponse response = new OperationUpdateResponse();
        response.setResponse("update failure...");

        Optional<OperationEntity> entity = repository.findByLink(request.getLink());
        if (entity.isPresent()) {
            entity.get().setExpiration(request.getExpiration());
            entity.get().setCreated_at(LocalDateTime.now());
            repository.save(entity.get());

            response.setResponse("successfully updated...");
        }

        return response;
    }

    public OperationReadResponse findByLink(OperationReadRequest request) {

        OperationEntity entity = repository.findByLink(request.getLink())
                .orElseThrow(() -> new LinkNotFoundException("request link : "+ request.getLink()+" not found"));

        ObjectEntity object = objectRepository.findById(entity.getLink())
                .orElseThrow(() -> new LinkNotFoundException("content : "+ request.getLink()+" not found"));
        return responseConverter.entityToReadDto(entity, object);

    }
}
