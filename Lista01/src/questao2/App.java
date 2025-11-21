package questao2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua altura (em metros): ");
        double altura = scanner.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(altura, peso);
        double imc = pessoa.calcularImc();

        System.out.printf("Seu IMC é: %.2f\n", imc);

        scanner.close();
    }
}
