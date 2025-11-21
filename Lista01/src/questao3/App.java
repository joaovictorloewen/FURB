package questao3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Pessoa %d:\n", i + 1);
            System.out.print("Altura (em metros): ");
            double altura = scanner.nextDouble();
            System.out.print("Peso (em kg): ");
            double peso = scanner.nextDouble();

            pessoas[i] = new Pessoa(altura, peso);
        }

        System.out.println("\nIMC das pessoas:");
        for (int i = 0; i < 3; i++) {
            double imc = pessoas[i].calcularImc();
            System.out.printf("Pessoa %d - IMC: %.2f\n", i + 1, imc);
        }

        scanner.close();
    }
}

