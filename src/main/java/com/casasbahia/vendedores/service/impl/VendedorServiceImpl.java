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
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendedorDTO findById(Long id) {
        Vendedor v = repository.findById(id)
                .orElseThrow(() -> new CustomException("Vendedor não encontrado"));
        return mapToDTO(v);
    }

    @Override
    public VendedorDTO create(VendedorDTO dto) {

        if (repository.existsByDocumento(dto.getDocumento())) {
            throw new CustomException("Documento já cadastrado");
        }

        String matricula = gerarMatricula(dto.getTipoContratacao());

        if (repository.existsByMatricula(matricula)) {
            throw new CustomException("Matrícula já cadastrada");
        }

        Vendedor v = new Vendedor();
        v.setMatricula(matricula);
        v.setNome(dto.getNome());
        v.setDataNascimento(dto.getDataNascimento());
        v.setDocumento(dto.getDocumento());
        v.setEmail(dto.getEmail());
        v.setTipoContratacao(dto.getTipoContratacao());
        v.setFilialId(dto.getFilialId());

        Vendedor saved = repository.save(v);
        return mapToDTO(saved);
    }

    @Override
    public VendedorDTO update(Long id, VendedorDTO dto) {
        Vendedor existing = repository.findById(id)
                .orElseThrow(() -> new CustomException("Vendedor não encontrado"));

        if (!existing.getDocumento().equals(dto.getDocumento())
                && repository.existsByDocumento(dto.getDocumento())) {
            throw new CustomException("Documento já cadastrado");
        }

        existing.setNome(dto.getNome());
        existing.setDataNascimento(dto.getDataNascimento());
        existing.setDocumento(dto.getDocumento());
        existing.setEmail(dto.getEmail());
        existing.setTipoContratacao(dto.getTipoContratacao());
        existing.setFilialId(dto.getFilialId());
        Vendedor updated = repository.save(existing);
        return mapToDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private VendedorDTO mapToDTO(Vendedor v) {
        VendedorDTO dto = new VendedorDTO();
        dto.setId(v.getId());
        dto.setMatricula(v.getMatricula());
        dto.setNome(v.getNome());
        dto.setDataNascimento(v.getDataNascimento());
        dto.setDocumento(v.getDocumento());
        dto.setEmail(v.getEmail());
        dto.setTipoContratacao(v.getTipoContratacao());
        dto.setFilialId(v.getFilialId());
        return dto;
    }

    private String gerarMatricula(String tipoContratacao) {

        long count = repository.count() + 1;
        String sufixo;
        switch (tipoContratacao.toUpperCase()) {
            case "OUTSOURCING": sufixo = "OUT"; break;
            case "CLT": sufixo = "CLT"; break;
            case "PESSOA JURÍDICA": sufixo = "PJ"; break;
            default: sufixo = "OUT";
        }
        return String.format("%08d-%s", count, sufixo);
    }
}
