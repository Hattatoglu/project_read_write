package dev.eyaz.exmpl.service.read.service;

import dev.eyaz.exmpl.service.read.converter.ResponseConverter;
import dev.eyaz.exmpl.service.read.dto.request.OperationReadRequest;
import dev.eyaz.exmpl.service.read.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.read.exception.LinkNotFoundException;
import dev.eyaz.exmpl.service.read.model.ObjectEntity;
import dev.eyaz.exmpl.service.read.model.OperationEntity;
import dev.eyaz.exmpl.service.read.repository.ObjectRepository;
import dev.eyaz.exmpl.service.read.repository.OperationRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReadService {

    private final OperationRepository repository;
    private final ObjectRepository objectRepository;
    private final ResponseConverter responseConverter;

    public ReadService(OperationRepository repository, ObjectRepository objectRepository,
                       ResponseConverter responseConverter) {
        this.repository = repository;
        this.objectRepository = objectRepository;
        this.responseConverter = responseConverter;
    }

    @Cacheable(value = "contents", key = "#link", unless = "#result == null")
    public OperationReadResponse getContent(String link) {

        OperationEntity entity = repository.findByLink(link)
                .orElseThrow(() -> new LinkNotFoundException("request link : "+ link +" not found"));

        ObjectEntity object = objectRepository.findById(link)
                .orElseThrow(() -> new LinkNotFoundException("content : "+ link +" not found"));
        return responseConverter.entityToReadDto(entity, object);

    }
}
