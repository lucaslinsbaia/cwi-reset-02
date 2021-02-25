package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.TipoTransacao;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Transacao {

    private TipoTransacao tipoTransacao;
    private LocalDate dataTransacao;
    private Double valorTransacao;


    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransacao, Double valorTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public Double getValorTransacao() {
        return valorTransacao;
    }

    public void imprimirTransacao() {
        String valorTransacao = DecimalFormat.getCurrencyInstance().format(getValorTransacao());
        System.out.println(tipoTransacao.getTipoTransacao() + valorTransacao + " na data de " + Data.getDataTransacao());
    }
}

