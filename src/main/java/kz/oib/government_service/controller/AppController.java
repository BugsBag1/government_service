package kz.oib.government_service.controller;

import jakarta.validation.Valid;
import kz.oib.government_service.model.dto.GovernmentServiceRequestDTO;
import kz.oib.government_service.model.dto.GovernmentServiceResponseDTO;
import kz.oib.government_service.service.GovernmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "government-service")
@RequiredArgsConstructor
public class AppController {
    private final GovernmentService service;

    @PostMapping(path = "/create")
    public ResponseEntity<GovernmentServiceResponseDTO> create(
            @Valid @RequestBody GovernmentServiceRequestDTO requestDTO){
        return ResponseEntity.ok(service.create(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GovernmentServiceResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody GovernmentServiceRequestDTO requestDTO){
        return ResponseEntity.ok(service.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GovernmentServiceResponseDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/getAll")
    public List<GovernmentServiceResponseDTO> getAll(){
        return service.getAll();
    }
}
