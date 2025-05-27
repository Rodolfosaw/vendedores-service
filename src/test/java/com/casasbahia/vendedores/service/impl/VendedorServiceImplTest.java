package com.casasbahia.vendedores.service.impl;

import com.casasbahia.vendedores.dto.VendedorDTO;
import com.casasbahia.vendedores.exception.CustomException;
import com.casasbahia.vendedores.model.Vendedor;
import com.casasbahia.vendedores.repository.VendedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendedorServiceImplTest {

    @Mock
    private VendedorRepository repository;

    @InjectMocks
    private VendedorServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_DeveCriarVendedor_ComSucesso() {
        VendedorDTO dto = new VendedorDTO();
        dto.setNome("Fulano");
        dto.setDocumento("12345678901");
        dto.setEmail("fulano@teste.com");
        dto.setTipoContratacao("CLT");
        dto.setFilialId(1L);

        when(repository.existsByDocumento(dto.getDocumento())).thenReturn(false);
        when(repository.existsByMatricula(anyString())).thenReturn(false);

        Vendedor vendedorSalvo = new Vendedor();
        vendedorSalvo.setId(1L);
        vendedorSalvo.setMatricula("00000001-CLT");
        vendedorSalvo.setNome(dto.getNome());
        vendedorSalvo.setDocumento(dto.getDocumento());
        vendedorSalvo.setEmail(dto.getEmail());
        vendedorSalvo.setTipoContratacao(dto.getTipoContratacao());
        vendedorSalvo.setFilialId(dto.getFilialId());

        when(repository.save(any(Vendedor.class))).thenReturn(vendedorSalvo);

        VendedorDTO result = service.create(dto);

        assertNotNull(result.getId());
        assertEquals("00000001-CLT", result.getMatricula());
        assertEquals("Fulano", result.getNome());
        verify(repository, times(1)).save(any(Vendedor.class));
    }

    @Test
    void create_DeveLancarErro_QuandoDocumentoDuplicado() {
        VendedorDTO dto = new VendedorDTO();
        dto.setDocumento("12345678901");

        when(repository.existsByDocumento(dto.getDocumento())).thenReturn(true);

        CustomException ex = assertThrows(CustomException.class, () -> service.create(dto));
        assertEquals("Documento já cadastrado", ex.getMessage());
    }

    @Test
    void findById_DeveRetornarVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(1L);
        vendedor.setNome("Fulano");

        when(repository.findById(1L)).thenReturn(Optional.of(vendedor));

        VendedorDTO result = service.findById(1L);

        assertNotNull(result);
        assertEquals("Fulano", result.getNome());
    }

    @Test
    void findById_DeveLancarExcecao_SeNaoEncontrar() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        CustomException ex = assertThrows(CustomException.class, () -> service.findById(1L));
        assertEquals("Vendedor não encontrado", ex.getMessage());
    }

    @Test
    void update_DeveAtualizarVendedor_ComSucesso() {
        Vendedor existing = new Vendedor();
        existing.setId(1L);
        existing.setDocumento("12345678901");
        existing.setNome("Antigo");

        VendedorDTO dto = new VendedorDTO();
        dto.setNome("Novo Nome");
        dto.setDocumento("12345678901");
        dto.setEmail("novo@teste.com");
        dto.setTipoContratacao("CLT");
        dto.setFilialId(2L);

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.existsByDocumento(dto.getDocumento())).thenReturn(false);
        when(repository.save(any(Vendedor.class))).thenAnswer(i -> i.getArgument(0));

        VendedorDTO result = service.update(1L, dto);

        assertEquals("Novo Nome", result.getNome());
        assertEquals("12345678901", result.getDocumento());
        verify(repository, times(1)).save(any(Vendedor.class));
    }
}
