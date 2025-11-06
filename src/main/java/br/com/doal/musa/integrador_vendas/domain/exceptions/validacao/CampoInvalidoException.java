package br.com.doal.musa.integrador_vendas.domain.exceptions.validacao;

public class CampoInvalidoException extends RuntimeException {
    public CampoInvalidoException(String message) {
        super(message);
    }
}
