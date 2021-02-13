package exercicio.um;

public class Ator {
   private String nome;
   private int idade;
   private int oscarsVencidos;
   private Genero genero;

   public Ator(String nome, int idade, int oscarsVencidos, Genero genero) {
       this.nome = nome;
       this.idade = idade;
       this.oscarsVencidos = oscarsVencidos;
       this.genero = genero;
    }

    public void imprimeAtor() {
        System.out.println("Dados do Ator");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getGenero());
    }
}
