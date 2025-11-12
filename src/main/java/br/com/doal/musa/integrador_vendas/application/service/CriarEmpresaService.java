package br.com.doal.musa.integrador_vendas.application.service;

import br.com.doal.musa.integrador_vendas.domain.model.Empresa;
import br.com.doal.musa.integrador_vendas.domain.usecases.CriarEmpresaUseCase;
import br.com.doal.musa.integrador_vendas.infrastructure.database.entities.EmpresaEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarEmpresaService implements CriarEmpresaUseCase {
    @Override
    public Optional<EmpresaEntity> executar(Empresa empresa) {
        return Optional.empty();
    }
}
