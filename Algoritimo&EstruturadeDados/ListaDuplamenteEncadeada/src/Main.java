public class Main {

    public static void main(String[] args) {

        ListaDupla<Integer> lista = new ListaDupla<>();

        // Inserção
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        System.out.println("Lista: " + lista);

        // Buscar
        System.out.println("Buscar 20: " + lista.buscar(20).getInfo());
        System.out.println("Buscar 10: " + lista.buscar(10).getInfo());

        // Remover início
        lista.retirar(20);
        System.out.println("Após remover 20: " + lista);

        // Remover meio
        lista.retirar(10);
        System.out.println("Após remover 10: " + lista);

        // Remover fim
        lista.retirar(5);
        System.out.println("Após remover 5: " + lista);

        // Exibir inverso
        System.out.print("Ordem inversa: ");
        lista.exibirOrdemInversa();

        // Liberar
        lista.liberar();
        System.out.println("Após liberar: " + lista);
    }
}