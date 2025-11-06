package br.com.doal.musa.integrador_vendas.domain.repository;

import br.com.doal.musa.integrador_vendas.domain.model.Empresa;

import java.util.Optional;

public interface EmpresaRepository {

    Optional<Empresa> findById(Long id);

    void save(Empresa empresa);

    Optional<Empresa> findByCgcCpf(String cgcCpf);
}
