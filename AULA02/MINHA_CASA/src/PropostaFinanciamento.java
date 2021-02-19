
public class PropostaFinanciamento {
    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazoPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazoPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoPagamento = prazoPagamento;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public void imprimirPropostaAprovada() {
        System.out.println("Parabéns, " + beneficiario.getNome() + "! Sua proposta para o " + imovel.apresentacao() + " foi aceita!");
    }

    public void imprimirPropostaNegada() {
        System.out.println("Que vacilo, " + beneficiario.getNome() + "! Perdi o maior tempão e a P***A da tua proposta para o " + imovel.apresentacao() + " foi negada!");
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {
        if ((beneficiario.getSalario()*prazoPagamento) >= (imovel.getValorImovel()/2)) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }

    }
}