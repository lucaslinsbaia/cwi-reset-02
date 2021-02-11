public class Aplicacao {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("José", 6.5);
        String nome = aluno.nome;
        double notaFinal = aluno.notaFinal;
        aluno.setAprovado();
        String aprovado = aluno.isAprovado();

        System.out.println("O aluno "+nome+"recebeu a nota final "+notaFinal+" e foi "+aprovado);

    }
}
