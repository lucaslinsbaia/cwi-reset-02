public class Imovel {
    private String enderecoImovel;
    private Double valorImovel;

    public Imovel(String enderecoImovel, Double valorImovel) {
        this.enderecoImovel = enderecoImovel;
        this.valorImovel = valorImovel;
    }

    public String getEnderecoImovel() {
        return enderecoImovel;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public String void apresentacao() {
        System.out.println("imóvel localizado no endereço " + enderecoImovel + ". Valor: R$ " + valorImovel);
    }
}
