package br.com.banco.desgraca.exception;

public class ContaPoupancaException extends RuntimeException {
    public ContaPoupancaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
