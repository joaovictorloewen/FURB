package questao4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Pessoa %d:\n", i + 1);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Altura (em metros): ");
            double altura = scanner.nextDouble();
            System.out.print("Peso (em kg): ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            pessoas[i] = new Pessoa(nome, altura, peso);
        }

        System.out.println("\nDados em ordem inversa:");
        for (int i = 2; i >= 0; i--) {
            Pessoa p = pessoas[i];
            System.out.printf("Nome: %s\n", p.getNome());
            System.out.printf("Altura: %.2f m\n", p.getAltura());
            System.out.printf("Peso: %.2f kg\n", p.getPeso());
            System.out.printf("IMC: %.2f\n\n", p.calcularImc());
        }

        scanner.close();
    }
}

