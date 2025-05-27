package com.casasbahia.vendedores.controller;

import com.casasbahia.vendedores.dto.VendedorDTO;
import com.casasbahia.vendedores.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendedores")
public class VendedorController {

    private final VendedorService service;

    public VendedorController(VendedorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> create(@RequestBody @Valid VendedorDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Long id, @RequestBody @Valid VendedorDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
