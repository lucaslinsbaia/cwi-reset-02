
package br.com.banco.desgraca.domain;

public enum TipoTransacao {
    SAQUE ("Sacando o valor de ", " - "),
    DEPOSITO("Depositando o valor de ", " + "),
    TRANSFERENCIA_PARA_OUTROS_BANCOS ("Transferindo o valor de ", " - "),
    TRANSFERENCIA_PARA_MESMO_BANCO ("Transferindo o valor de ", " - ");

    String sinalTransacao;
    String tipoTransacao;

    TipoTransacao(String tipoTransacao, String sinalTransacao)
    {
        this.tipoTransacao = tipoTransacao;
        this.sinalTransacao = sinalTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public String getSinalTransacao() {
        return sinalTransacao;
    }
}
