package questao1;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1.75, 78);
        double imc = pessoa.calcularImc();
        System.out.printf("O IMC da pessoa é: %.2f\n", imc);
    }
}
