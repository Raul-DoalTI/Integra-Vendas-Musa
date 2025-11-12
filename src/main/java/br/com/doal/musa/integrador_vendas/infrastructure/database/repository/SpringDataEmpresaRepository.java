package br.com.doal.musa.integrador_vendas.infrastructure.database.repository;

import br.com.doal.musa.integrador_vendas.infrastructure.database.entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataEmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
    Optional<EmpresaEntity> findByCgcCpf(String cgcCpf);
}
