package com.mercantiservice.vendedores.repository;

import com.mercantiservice.vendedores.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    boolean existsByDocumento(String documento);

    boolean existsByMatricula(String matricula);
}
