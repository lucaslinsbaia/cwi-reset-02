package exercicio.um;

import java.util.List;

public class Filme {
    private String titulo;
    private String descricao;
    private int duracao;
    private String lancamento;
    private int avaliacao;
    private Diretor diretor;
    private List<Pessoa> elenco;

    public Filme(String titulo, String descricao, int duracao, String lancamento, int avaliacao, Diretor diretor, List<Pessoa> elenco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.lancamento = lancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
        this.elenco = elenco;
    }



    public void reproduzirFilme() {
        System.out.println("Nome do filme: "+ this.titulo);
        System.out.println("Sinopse: "+ this.descricao);
        System.out.println("Duração: "+ this.duracao + "min");
        System.out.println("Direção: "+ this.diretor.getNome());
    }

    public void exibirCreditos() {
        for (Pessoa pessoa : this.elenco) {
            System.out.println(pessoa.);
        }


    }
}
