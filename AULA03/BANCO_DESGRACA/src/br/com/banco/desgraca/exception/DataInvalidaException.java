package br.com.banco.desgraca.exception;

public class DataInvalidaException extends RuntimeException{
    public DataInvalidaException(String mensagemDeErro) {
        super(mensagemDeErro);

    }
}
