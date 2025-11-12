package br.com.doal.musa.integrador_vendas.domain.usecases;

import br.com.doal.musa.integrador_vendas.domain.model.Empresa;
import br.com.doal.musa.integrador_vendas.infrastructure.database.entities.EmpresaEntity;

import java.util.Optional;

public interface CriarEmpresaUseCase {
    Optional<EmpresaEntity> executar(Empresa empresa);
}
