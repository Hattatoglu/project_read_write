package dev.eyaz.exmpl.service.write.api;

import dev.eyaz.exmpl.service.write.dto.request.OperationCreateRequest;
import dev.eyaz.exmpl.service.write.dto.request.OperationDeleteRequest;
import dev.eyaz.exmpl.service.write.dto.request.OperationReadRequest;
import dev.eyaz.exmpl.service.write.dto.request.OperationUpdateRequest;
import dev.eyaz.exmpl.service.write.dto.response.OperationCreateResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationDeleteResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.write.dto.response.OperationUpdateResponse;
import dev.eyaz.exmpl.service.write.service.WriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/op/write")
public class OperationWriteController {

    private final WriteService writeService;

    public OperationWriteController(WriteService writeService) {
        this.writeService = writeService;
    }

    @PostMapping
    public ResponseEntity<OperationCreateResponse> createOperation(@RequestBody OperationCreateRequest request) {
        return ResponseEntity.ok(writeService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<OperationDeleteResponse> deleteOperation(@RequestBody OperationDeleteRequest request) {
        return ResponseEntity.ok(writeService.deleteOperation(request));
    }

    @GetMapping
    public ResponseEntity<OperationReadResponse> getOperation(@RequestBody OperationReadRequest request) {
        return ResponseEntity.ok(writeService.findByLink(request));
    }

    @PutMapping
    public ResponseEntity<OperationUpdateResponse> updateOperation(@RequestBody OperationUpdateRequest request) {
        return ResponseEntity.ok(writeService.updateOperation(request));
    }
}
