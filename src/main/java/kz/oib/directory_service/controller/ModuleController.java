package kz.oib.directory_service.controller;

import kz.oib.directory_service.model.dto.ModuleRequestDTO;
import kz.oib.directory_service.model.dto.ModuleResponseDTO;
import kz.oib.directory_service.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService service;

    @GetMapping
    public List<ModuleResponseDTO> getAllModules() {
        return service.getAll();
    }

    @GetMapping(path = "/getActualModule")
    public List<ModuleResponseDTO> getActualModule() {
        return service.getActual();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ModuleResponseDTO> createModule(@RequestBody ModuleRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleResponseDTO> updateModule(@PathVariable Long id, @RequestBody ModuleRequestDTO request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        service.delete(id);
    }
}
