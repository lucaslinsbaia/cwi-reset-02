package exercicio.um;


public class Aplicacao {
        public static void main(String[] args) {
            Diretor alberto = new Diretor("Alberto Moraes", 35, 15);
            Diretor joaquim = new Diretor("Joaquim Ferreira", 58, 11);
            Filme filme1 = new Filme("Silêncio dos Inocentes", "Filme que o cara come os outros, no mau sentido",
                    95, "1997", 5, alberto);

            Filme filme2 = new Filme("Star Wars", "Gente grande que luta de espadinha",
                    180, "1977", 3, joaquim);


            filme1.reproduzirFilme();
            filme2.reproduzirFilme();
        }
    }
