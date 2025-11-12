package br.com.doal.musa.integrador_vendas.domain.model;

import br.com.doal.musa.integrador_vendas.domain.exceptions.validacao.CampoInvalidoException;
import br.com.doal.musa.integrador_vendas.domain.model.VOs.CgcCpf;

import java.util.Objects;

public class Empresa {

    private final Long id;
    private final String nomeFantasia;
    private final String razaoSocial;
    private final CgcCpf cgcCpf;

    private Empresa(Long id, String nomeFantasia, String razaoSocial, String cgcCpf) {
        if (id == null) {
            throw new IllegalArgumentException("ID da empresa não pode ser nulo");
        }
        this.id = id;
        this.nomeFantasia = validarTexto(nomeFantasia, "Nome fantasia");
        this.razaoSocial = validarTexto(razaoSocial, "Razão social");
        this.cgcCpf = CgcCpf.of(cgcCpf);
    }

    public static Empresa criar(Long id, String nomeFantasia, String razaoSocial, String cgcCpf) {
        return new Empresa(id, nomeFantasia, razaoSocial, cgcCpf);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new CampoInvalidoException(campo + " não pode ser vazio ou nulo!");
        }
        return valor.trim();
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCgcCpf() {
        return cgcCpf.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empresa{" +
               "id=" + id +
               ", nomeFantasia='" + nomeFantasia + '\'' +
               ", razaoSocial='" + razaoSocial + '\'' +
               ", cgcCpf=" + cgcCpf +
               '}';
    }
}
