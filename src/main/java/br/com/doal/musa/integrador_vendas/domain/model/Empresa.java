package br.com.doal.musa.integrador_vendas.domain.model;

import br.com.doal.musa.integrador_vendas.domain.exceptions.validacao.CampoInvalidoException;

import java.util.Objects;

public class Empresa {

    private final Long id;
    private final String nomeFantasia;
    private final String razaoSocial;
    private final String cgcCpf;

    private Empresa(Long id, String nomeFantasia, String razaoSocial, String cgcCpf){
        this.id = Objects.requireNonNull(id, "ID da empresa não pode ser nulo");
        this.nomeFantasia = validarTexto(nomeFantasia, "Nome fantasia");
        this.razaoSocial = validarTexto(razaoSocial, "Razão social");
        this.cgcCpf = validarTexto(cgcCpf, "CGC/CPF");
    }

    public static Empresa criar(Long id, String nomeFantasia, String razaoSocial, String cgcCpf){
        return new Empresa(id, nomeFantasia, razaoSocial, cgcCpf);
    }

    private  static String validarTexto(String valor, String campo){

        if (valor == null || valor.isBlank()){
            throw new CampoInvalidoException("O campo não pode ser vazio ou nulo!");
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
        return cgcCpf;
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
                ", cgcCpf='" + cgcCpf + '\'' +
                '}';
    }
}
