package exercicio.um;

public class Diretor {
    private String nome;
    private int idade;
    private int quantidadeDeFilmes;

    public Diretor(String nome, int idade, int quantidadeDeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmes = quantidadeDeFilmes;
    }

    public String getNome() {
        return nome;
    }
}
