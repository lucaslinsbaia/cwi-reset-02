
public class Aplicacao {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int soma1 = calculadora.soma(10, 78);
        System.out.println("O resultado da soma é " + soma1);

        int subtracao1 = calculadora.subtrai(78, 10);
        System.out.println("O resultado da subtração é " + subtracao1);

        int multiplica1 = calculadora.multipica(10, 850);
        System.out.println("O resultado da multiplicação é " + multiplica1);

        int divisao1 = calculadora.divide(850, 10);
        System.out.println("O resultado da divisão é " + divisao1);
    }


}
