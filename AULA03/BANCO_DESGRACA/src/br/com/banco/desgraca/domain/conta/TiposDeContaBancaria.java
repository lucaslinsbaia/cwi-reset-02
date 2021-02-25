package br.com.banco.desgraca.domain.conta;

public enum TiposDeContaBancaria {
    CONTA_DIGITAL ("Conta Digital ", 0.0, 10, 0.0, 0.0),
    CONTA_CORRENTE ("Conta Corrente ", 0.0, 5, 0.0, 0.01),
    CONTA_POUPANCA("Conta Poupança ", 2.0,50,0.05,0.1);

    private String tipoDeConta;
    private Double taxaSaque;
    private int valorMinimoSaque;
    private Double taxaTransferenciaMesmoBanco;
    private Double taxaTransferenciaOutroBanco;

    TiposDeContaBancaria(String tipoDeConta, Double taxaSaque, int valorMinimoSaque, Double taxaTransferenciaMesmoBanco, Double taxaTransferenciaOutroBanco) {
        this.tipoDeConta = tipoDeConta;
        this.taxaSaque = taxaSaque;
        this.valorMinimoSaque = valorMinimoSaque;
        this.taxaTransferenciaMesmoBanco = taxaTransferenciaMesmoBanco;
        this.taxaTransferenciaOutroBanco = taxaTransferenciaOutroBanco;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public Double getTaxaSaque() {
        return taxaSaque;
    }

    public int getValorMinimoSaque() {
        return valorMinimoSaque;
    }

    public Double getTaxaTransferenciaMesmoBanco() {
        return taxaTransferenciaMesmoBanco;
    }

    public Double getTaxaTransferenciaOutroBanco() {
        return taxaTransferenciaOutroBanco;
    }


}
