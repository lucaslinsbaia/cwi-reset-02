public class Beneficiario {
    private String nomeBeneficiario;
    private Double salarioBeneficiario;

    public Beneficiario(String nomeBeneficiario, Double salarioBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
        this.salarioBeneficiario = salarioBeneficiario;
    }

    public String getNome() {
        return nomeBeneficiario;
    }

    public Double getSalario() {
        return salarioBeneficiario;
    }
}
