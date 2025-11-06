package br.com.doal.musa.integrador_vendas.domain.model.VOs;

import br.com.doal.musa.integrador_vendas.domain.exceptions.validacao.CampoInvalidoException;

import java.util.Objects;

public class CgcCpf {

    private final String value;

    private CgcCpf(String value){
        this.value = value;
    }

    public static CgcCpf of(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new CampoInvalidoException("CGC/CPF não pode ser nulo ou vazio");
        }
        String digits = raw.replaceAll("[^0-9]", "");
        if (!(digits.length() == 11 || digits.length() == 14)) {
            throw new CampoInvalidoException("CGC/CPF inválido. Deve conter 11 (CPF) ou 14 (CNPJ) dígitos");
        }
        return new CgcCpf(digits);
    }

    public  String getValue(){
        return  value;
    }
    public boolean isCpf(){
        return value.length() == 11;
    }
    public boolean isCnpj(){
        return value.length() == 14;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass()
                != o.getClass()) return false;
        CgcCpf cgcCpf = (CgcCpf) o;
        return Objects.equals(value, cgcCpf.value);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CgcCpf{" +
                "value='" + value + '\'' +
                '}';
    }
}
