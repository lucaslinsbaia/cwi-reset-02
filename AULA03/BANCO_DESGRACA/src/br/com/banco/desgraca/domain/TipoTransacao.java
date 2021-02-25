
package br.com.banco.desgraca.domain;

public enum TipoTransacao {
    SAQUE ("Sacando o valor de ", true),
    DEPOSITO("Depositando o valor de ", true),
    PAGAMENTO ("Pagando o valor de ", true),
    TRANSFERENCIA_PARA_OUTROS_BANCOS ("Transferindo o valor de ", true),
    TRANSFERENCIA_PARA_MESMO_BANCO ("Transferindo o valor de ", true);

    Boolean executar;
    String tipoTransacao;

    TipoTransacao(String tipoTransacao, Boolean executar)
    {
        this.tipoTransacao = tipoTransacao;
        this.executar = executar;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public Boolean getExecutar() {
        return executar;
    }
}
