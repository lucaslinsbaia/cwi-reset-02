package br.com.banco.desgraca.exception;

public class DepositoInvalidoException extends RuntimeException {
    public DepositoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
