package Questao02;

import java.util.Scanner;

public class AAPQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 5;
        Livro[] acervo = new Livro[N];

        System.out.println("=== Cadastro de Livros ===");
        for (int i = 0; i < N; i++) {
            System.out.printf("Livro %d - deseja cadastro rápido (padrão)? (s/n): ", i+1);
            String opc = sc.nextLine().trim().toLowerCase();
            if (opc.equals("s")) {
                acervo[i] = new Livro();
            } else {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Autor: ");
                String autor = sc.nextLine();
                System.out.print("Ano de publicação: ");
                int ano = Integer.parseInt(sc.nextLine());
                acervo[i] = new Livro(titulo, autor, ano);
            }
        }

        System.out.println("\n=== Informações completas ===");
        for (Livro l : acervo) {
            System.out.println(l.exibirInfo());
        }

        System.out.println("\nTotal de livros cadastrados: " + Livro.getTotalLivros());

        if (acervo.length > 0) {
            System.out.println("\n=== Exibição resumida do primeiro livro ===");
            System.out.println(acervo[0].exibirInfo(true));
        }

        sc.close();
    }
}