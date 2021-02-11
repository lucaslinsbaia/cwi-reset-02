public class Aluno {
    public String nome;
    public double notaFinal;
    public boolean aprovado;

    public Aluno(String nome, double notaFinal) {
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    public boolean setAprovado() {
        aprovado = notaFinal >= 7;
        return true;
    }

    public String isAprovado() {
        if(aprovado) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
}