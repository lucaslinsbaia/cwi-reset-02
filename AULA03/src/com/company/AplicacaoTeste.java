package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumerador.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {
    public static void main(String[] args) {
//        Editora marvel = new Editora("Marvel", "Rua do Limoeiro");
//        Editora dc = new Editora("DC Comics", "Rua do Pessegueiro");
//        Editora atica = new Editora("Ática", "Rua do Adroaldo");
//        Editora atica2 = new Editora("Ática", "Rua do Limoeiro, 350");
        Diretor nolan = new Diretor ("Cristopher Nolan", 55, 12, Genero.MASCULINO);
        Filme filme = new Filme("Interestellar", "Gente que acha que existe alienígena mas na verdade " +
                "só existe a gravidade", 120, 2018, 7, nolan);

    }



}
