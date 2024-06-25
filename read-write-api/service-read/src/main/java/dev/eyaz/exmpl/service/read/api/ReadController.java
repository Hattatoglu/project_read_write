package dev.eyaz.exmpl.service.read.api;

import dev.eyaz.exmpl.service.read.dto.response.OperationReadResponse;
import dev.eyaz.exmpl.service.read.service.ReadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/op/read")
public class ReadController {

    private final ReadService readService;

    public ReadController(ReadService readService) {
        this.readService = readService;
    }

    @GetMapping("/{link}")
    public ResponseEntity<OperationReadResponse> getContent(@Valid @PathVariable String link) {
        return ResponseEntity.ok(readService.getContent(link));

    }
}
