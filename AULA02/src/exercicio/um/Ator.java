package exercicio.um;

public class Ator extends Pessoa {
   private String nome;
   private int idade;
   private int oscarsVencidos;
   private Genero genero;

   public Ator(String nome, int idade, int oscarsVencidos, Genero genero) {
       super(nome, idade, genero);
       this.oscarsVencidos = oscarsVencidos;
    }



}
