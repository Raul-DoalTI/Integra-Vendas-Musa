package br.com.doal.musa.integrador_vendas.infrastructure.database.repository;

import br.com.doal.musa.integrador_vendas.domain.model.Empresa;
import br.com.doal.musa.integrador_vendas.domain.repository.EmpresaRepository;
import br.com.doal.musa.integrador_vendas.infrastructure.database.entities.EmpresaEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmpresaJpaRepository implements EmpresaRepository {

    private final SpringDataEmpresaRepository springDataRepository;

    public EmpresaJpaRepository(SpringDataEmpresaRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return springDataRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public void save(Empresa empresa) {
        EmpresaEntity entity = toEntity(empresa);
        springDataRepository.save(entity);
    }

    @Override
    public Optional<Empresa> findByCgcCpf(String cgcCpf) {
        return springDataRepository.findByCgcCpf(cgcCpf)
                .map(this::toDomain);
    }

    private Empresa toDomain(EmpresaEntity entity) {
        return  Empresa.criar(
                entity.getId(),
                entity.getNomeFantasia(),
                entity.getRazaoSocial(),
                entity.getCgcCpfDigits());
    }

    private EmpresaEntity toEntity(Empresa empresa) {
        EmpresaEntity entity = new EmpresaEntity(
                empresa.getId(),
                empresa.getNomeFantasia(),
                empresa.getCgcCpf(),
                empresa.getCgcCpf()
        );
        return entity;
    }
}
