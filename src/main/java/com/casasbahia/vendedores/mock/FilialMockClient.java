package com.casasbahia.vendedores.mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilialMockClient {

    public Map<String, Object> findFilialById(Long id) {

        Map<String, Object> filial = new HashMap<>();
        filial.put("id", id);
        filial.put("nome", "Filial Exemplo " + id);
        filial.put("cnpj", "00.000.000/0001-" + String.format("%02d", id));
        filial.put("cidade", "São Paulo");
        filial.put("uf", "SP");
        filial.put("tipo", "Matriz");
        filial.put("ativo", true);
        filial.put("dataCadastro", "2020-01-01");
        filial.put("ultimaAtualizacao", "2025-01-01");
        return filial;
    }
}
