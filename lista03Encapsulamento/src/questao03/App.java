package questao03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número da 1ª conta: ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular da 1ª conta: ");
        String tit1 = sc.nextLine();
        ContaBancaria conta1 = new ContaBancaria(num1, tit1);

        System.out.print("Número da 2ª conta: ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular da 2ª conta: ");
        String tit2 = sc.nextLine();
        ContaBancaria conta2 = new ContaBancaria(num2, tit2);

        conta1.depositar(1000.0);
        conta1.depositar(700.0);

        conta2.depositar(5000.0);
        conta2.sacar(3000.0);

        conta2.transferir(conta1, 1800.0);

        System.out.println("\n--- Saldo final ---");
        System.out.println(conta1.getTitular() + " - Saldo: R$ " + conta1.getSaldo());
        System.out.println(conta2.getTitular() + " - Saldo: R$ " + conta2.getSaldo());

        sc.close();
    }
}
