package br.com.doal.musa.integrador_vendas.infrastructure.mapper;

import br.com.doal.musa.integrador_vendas.domain.model.Empresa;
import br.com.doal.musa.integrador_vendas.infrastructure.database.entities.EmpresaEntity;

public final class EmpresaMapper {

    private EmpresaMapper() {}

    public static EmpresaEntity toEntity(Empresa empresa) {
        return new EmpresaEntity(
                empresa.getId(),
                empresa.getNomeFantasia(),
                empresa.getRazaoSocial(),
                empresa.getCgcCpf()
        );
    }

    public static Empresa toDomain(EmpresaEntity entity) {
        return Empresa.criar(
                entity.getId(),
                entity.getNomeFantasia(),
                entity.getRazaoSocial(),
                entity.getCgcCpfDigits()
        );
    }

}
