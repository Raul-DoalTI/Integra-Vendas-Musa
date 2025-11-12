package br.com.doal.musa.integrador_vendas.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "empresa")
public class EmpresaEntity {

    @Id
    private Long id;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "cgc_cpf", nullable = false, length = 14)
    private String cgcCpfDigits;

    protected EmpresaEntity() {
        // Para JPA
    }

    public EmpresaEntity(Long id, String nomeFantasia, String razaoSocial, String cgcCpfDigits) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cgcCpfDigits = cgcCpfDigits;
    }

    public Long getId() { return id; }
    public String getNomeFantasia() { return nomeFantasia; }
    public String getRazaoSocial() { return razaoSocial; }
    public String getCgcCpfDigits() { return cgcCpfDigits; }

    public void setId(Long id) { this.id = id; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public void setCgcCpfDigits(String cgcCpfDigits) { this.cgcCpfDigits = cgcCpfDigits; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpresaEntity)) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
