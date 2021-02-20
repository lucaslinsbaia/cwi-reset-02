public enum UnidadeFederativa {
    AC ("Acre"),
    AL ("Alagoas"),
    AP ("Amapá"),
    AM ("Amazonas"),
    BA ("Bahia"),
    CE ("Ceará"),
    DF ("Distrito Federal"),
    ES ("Espírito Santo"),
    GO ("Goiás"),
    MA ("Maranhão"),
    MT ("Mato Grosso"),
    MS ("Mato Grosso do Sul"),
    MG ("Minas Gerais"),
    PA ("Pará"),
    PB ("Paraíba"),
    PR ("Paraná"),
    PE ("Pernambuco"),
    PI ("Piauí"),
    RJ ("Rio de Janeiro", 0.60),
    RN ("Rio Grande do Norte"),
    RS ("Rio Grande do Sul"),
    RO ("Rondônia"),
    RR ("Roraima"),
    SC ("Santa Catarina"),
    SP ("São Paulo", 0.65),
    SE ("Sergipe"),
    TO ("Tocantins"),
    ;


    private String nome;
    private Double multiplicador;

    UnidadeFederativa (String nome) {
        this(nome, 0.5);
    }

    UnidadeFederativa(String nome, Double multiplicador) {
        this.nome = nome;
        this.multiplicador = multiplicador;
    }

    public String getNome() {
        return nome;
    }

    public Double getMultiplicador() {
        return multiplicador;
    }
}