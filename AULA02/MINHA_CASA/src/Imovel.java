import java.text.DecimalFormat;

public class Imovel {
    private Endereco endereco;
    private Double valor;

    public Imovel(Endereco endereco, Double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }

    public String apresentacao() {
    return String.format("Imóvel localizado na Rua %s, número %d, no bairro %s, cidade de %s / %s. " +
            "Valor do imóvel: %s", endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(),
            endereco.getCidade(), endereco.getEstado(), DecimalFormat.getCurrencyInstance().format(getValor()));

    }
}

