package main;

import fila.*;
import excecoes.*;

public class TesteFila {

    public static void main(String[] args) {

        System.out.println("===== PL01 - FILA VETOR =====");

        try {
            // Caso 1
            FilaVetor<Integer> f = new FilaVetor<>(5);
            System.out.println("Caso 1: " + (f.estaVazia() ? "OK" : "ERRO"));

            // Caso 2
            f.inserir(10);
            System.out.println("Caso 2: " + (!f.estaVazia() ? "OK" : "ERRO"));

            // Caso 3
            FilaVetor<Integer> f3 = new FilaVetor<>(10);
            f3.inserir(10);
            f3.inserir(20);
            f3.inserir(30);

            boolean ok3 = f3.retirar() == 10 &&
                          f3.retirar() == 20 &&
                          f3.retirar() == 30 &&
                          f3.estaVazia();

            System.out.println("Caso 3: " + (ok3 ? "OK" : "ERRO"));

            // Caso 4
            try {
                FilaVetor<Integer> f4 = new FilaVetor<>(3);
                f4.inserir(10);
                f4.inserir(20);
                f4.inserir(30);
                f4.inserir(40);
                System.out.println("Caso 4: ERRO");
            } catch (FilaCheiaException e) {
                System.out.println("Caso 4: OK");
            }

            // Caso 5
            try {
                FilaVetor<Integer> f5 = new FilaVetor<>(3);
                f5.retirar();
                System.out.println("Caso 5: ERRO");
            } catch (FilaVaziaException e) {
                System.out.println("Caso 5: OK");
            }

            // Caso 6
            FilaVetor<Integer> f6 = new FilaVetor<>(5);
            f6.inserir(10);
            f6.inserir(20);
            f6.inserir(30);

            boolean ok6 = f6.peek() == 10 && f6.retirar() == 10;
            System.out.println("Caso 6: " + (ok6 ? "OK" : "ERRO"));

            // Caso 7
            f6.liberar();
            System.out.println("Caso 7: " + (f6.estaVazia() ? "OK" : "ERRO"));

            // Caso 8
            FilaVetor<Integer> f1 = new FilaVetor<>(5);
            f1.inserir(10);
            f1.inserir(20);
            f1.inserir(30);

            FilaVetor<Integer> f2 = new FilaVetor<>(3);
            f2.inserir(40);
            f2.inserir(50);

            FilaVetor<Integer> fConcat = f1.criarFilaConcatenada(f2);

            boolean ok8 = fConcat.toString().equals("10,20,30,40,50") &&
                          f1.toString().equals("10,20,30") &&
                          f2.toString().equals("40,50") &&
                          fConcat.getLimite() == 8;

            System.out.println("Caso 8: " + (ok8 ? "OK" : "ERRO"));

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }

        System.out.println("\n===== PL02 - FILA LISTA =====");

        try {
            // Caso 1
            FilaLista<Integer> fl = new FilaLista<>();
            System.out.println("Caso 1: " + (fl.estaVazia() ? "OK" : "ERRO"));

            // Caso 2
            fl.inserir(10);
            System.out.println("Caso 2: " + (!fl.estaVazia() ? "OK" : "ERRO"));

            // Caso 3
            FilaLista<Integer> fl3 = new FilaLista<>();
            fl3.inserir(10);
            fl3.inserir(20);
            fl3.inserir(30);

            boolean ok3 = fl3.retirar() == 10 &&
                          fl3.retirar() == 20 &&
                          fl3.retirar() == 30 &&
                          fl3.estaVazia();

            System.out.println("Caso 3: " + (ok3 ? "OK" : "ERRO"));

            // Caso 4
            FilaLista<Integer> fl4 = new FilaLista<>();
            fl4.inserir(10);
            fl4.inserir(20);
            fl4.inserir(30);

            boolean ok4 = fl4.peek() == 10 && fl4.retirar() == 10;
            System.out.println("Caso 4: " + (ok4 ? "OK" : "ERRO"));

            // Caso 5
            fl4.liberar();
            System.out.println("Caso 5: " + (fl4.estaVazia() ? "OK" : "ERRO"));

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}