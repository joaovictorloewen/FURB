package Vetor;

public class Main {

    public static void main(String[] args) {

        ListaEstatica<Integer> lista = new ListaEstatica<>();

        // Caso 1
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        System.out.println("Caso 1: " + lista.toString());

        // Caso 2
        System.out.println("Caso 2: " + lista.getTamanho());

        // Caso 3
        System.out.println("Caso 3: " + lista.buscar(15));

        // Caso 4
        System.out.println("Caso 4: " + lista.buscar(30));

        // Caso 5
        lista.retirar(10);
        System.out.println("Caso 5 toString: " + lista.toString());
        System.out.println("Caso 5 tamanho: " + lista.getTamanho());

        // Caso 6 (forçar redimensionamento)
        ListaEstatica<Integer> lista2 = new ListaEstatica<>();
        for (int i = 1; i <= 15; i++) {
            lista2.inserir(i);
        }
        System.out.println("Caso 6: " + lista2.toString());
        System.out.println("Caso 6 tamanho: " + lista2.getTamanho());

        // Caso 7
        ListaEstatica<Integer> lista3 = new ListaEstatica<>();
        lista3.inserir(5);
        lista3.inserir(10);
        lista3.inserir(15);
        lista3.inserir(20);

        System.out.println("Caso 7: " + lista3.obterElemento(3));

        // Caso 8 (Exceção)
        try {
            System.out.println(lista3.obterElemento(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caso 8: Exceção lançada corretamente.");
        }

        // Caso 9
        lista3.liberar();
        System.out.println("Caso 9 (estaVazia): " + lista3.estaVazia());

        // ✅ Caso 10 – inverter quantidade PAR
        ListaEstatica<Integer> lista10 = new ListaEstatica<>();
        lista10.inserir(5);
        lista10.inserir(10);
        lista10.inserir(15);
        lista10.inserir(20);

        lista10.inverter();
        System.out.println("Caso 10: " + lista10.toString()); // 20,15,10,5

        // ✅ Caso 11 – inverter quantidade ÍMPAR
        ListaEstatica<Integer> lista11 = new ListaEstatica<>();
        lista11.inserir(5);
        lista11.inserir(10);
        lista11.inserir(15);
        lista11.inserir(20);
        lista11.inserir(25);

        lista11.inverter();
        System.out.println("Caso 11: " + lista11.toString()); // 25,20,15,10,5
    }
}