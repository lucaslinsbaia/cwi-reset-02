package exercicio.um;


public class Aplicacao {
        public static void main(String[] args) {
            Diretor alberto = new Diretor("Alberto Moraes", 35, 15, Genero.NAO_BINARIO);
            Diretor joaquim = new Diretor("Joaquim Ferreira", 58, 11, Genero.MASCULINO);
            Ator leoDiCaprio = new Ator("Leonardo DiCaprio",52,1,Genero.MASCULINO);
            Filme filme1 = new Filme("Silêncio dos Inocentes", "Filme que o cara come os outros, no mau sentido",
                    95, "1997", 5, alberto);

            Filme filme2 = new Filme("Star Wars", "Gente grande que luta de espadinha",
                    180, "1977", 3, joaquim);


            filme1.reproduzirFilme();
            System.out.println("-----------");
            leoDiCaprio.imprimeAtor();
            System.out.println("-----------");
            filme2.reproduzirFilme();
            System.out.println("-----------");
            alberto.imprimirDiretor();
            System.out.println("-----------");
        }
    }
