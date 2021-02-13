package exercicio.um;

public class Filme {
    private String titulo;
    private String descricao;
    private int duracao;
    private String lancamento;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String titulo, String descricao, int duracao, String lancamento, int avaliacao, Diretor diretor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.lancamento = lancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzirFilme() {
        System.out.println("Nome do filme: "+ this.titulo);
        System.out.println("Sinopse: "+ this.descricao);
        System.out.println("Duração: "+ this.duracao + "m");
        System.out.println("Direção: "+ this.diretor.getNome());
    }
}
