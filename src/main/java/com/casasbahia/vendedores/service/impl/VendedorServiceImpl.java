package com.casasbahia.vendedores.service.impl;

import com.casasbahia.vendedores.dto.VendedorDTO;
import com.casasbahia.vendedores.exception.CustomException;
import com.casasbahia.vendedores.model.Vendedor;
import com.casasbahia.vendedores.repository.VendedorRepository;
import com.casasbahia.vendedores.service.VendedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository repository;

    public VendedorServiceImpl(VendedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VendedorDTO> findAll() {
        return repository.findAll().stream()
                .map(v -> /* converter para DTO */ null)
                .collect(Collectors.toList());
    }

    @Override
    public VendedorDTO findById(Long id) {
        Vendedor v = repository.findById(id)
                .orElseThrow(() -> new CustomException("Vendedor não encontrado"));
        return /* converter para DTO */ null;
    }

    @Override
    public VendedorDTO create(VendedorDTO dto) {
        if (repository.existsByDocumento(dto.getDocumento())) {
            throw new CustomException("Documento já cadastrado");
        }
        Vendedor v = /* converter para entidade */ null;
        return /* salvar e converter para DTO */ null;
    }

    @Override
    public VendedorDTO update(Long id, VendedorDTO dto) {
        // similar à criação, com busca e merge
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
