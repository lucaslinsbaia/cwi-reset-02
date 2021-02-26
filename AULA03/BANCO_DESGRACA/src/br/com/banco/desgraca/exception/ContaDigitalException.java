package br.com.banco.desgraca.exception;

public class ContaDigitalException extends RuntimeException {
    public ContaDigitalException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
