package exercicio.um;

public enum Genero {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino"),
    NAO_BINARIO ("Não Binário");

    private String genero;

    public Genero(genero) {
        this.genero = genero;

    }

    public String getGenero() {
        return genero;
    }
}
