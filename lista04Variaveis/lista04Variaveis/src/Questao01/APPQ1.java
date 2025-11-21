package Questao01;

import java.util.Locale;
import java.util.Scanner;

public class APPQ1 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt","BR"));
        Scanner sc = new Scanner(System.in);

        int N = 5;
        Funcionario[] funcionarios = new Funcionario[N];

        System.out.println("=== Cadastro de Funcionários ===");
        for (int i = 0; i < N; i++) {
            System.out.printf("Funcionário %d - Nome: ", i+1);
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            double salario = Double.parseDouble(sc.nextLine().replace(",", "."));
            funcionarios[i] = new Funcionario(nome, salario);
        }

        System.out.println("\n=== Relação de Funcionários, Salário e IRPF ===");
        System.out.printf("%-25s %12s %12s%n", "Nome", "Salário (R$)", "IRPF (R$)");
        for (Funcionario f : funcionarios) {
            System.out.printf("%-25s %12.2f %12.2f%n",
                f.getNome(), f.getSalario(), f.calcularIrpf());
        }

        sc.close();
    }
}