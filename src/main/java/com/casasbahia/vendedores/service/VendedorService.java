package com.casasbahia.vendedores.service;

import com.casasbahia.vendedores.dto.VendedorDTO;
import java.util.List;

public interface VendedorService {
    List<VendedorDTO> findAll();
    VendedorDTO findById(Long id);
    VendedorDTO create(VendedorDTO dto);
    VendedorDTO update(Long id, VendedorDTO dto);
    void delete(Long id);
}

