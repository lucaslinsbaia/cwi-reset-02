package br.com.banco.desgraca.exception;

public class SaqueException extends RuntimeException {
    public SaqueException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
