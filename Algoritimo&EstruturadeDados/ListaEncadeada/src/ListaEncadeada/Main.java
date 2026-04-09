package ListaEncadeada;

public class Main {

	public static void main(String[] args) {

		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

		System.out.println("Lista está vazia? " + lista.estaVazia());

		lista.inserir(5);
		System.out.println("Lista está vazia após inserir o nº 5? " + lista.estaVazia());

		NoLista<Integer> primeiro = lista.getPrimeiro();
		System.out.println("Primeiro elemento da lista: " + primeiro.getInfo());

		lista.inserir(10);
		lista.inserir(15);

		System.out.println("Lista completa: " + lista);

		lista.inserir(20);

		System.out.println("Buscar o nº 20: " + lista.buscar(20).getInfo());
		System.out.println("Buscar o nº 15: " + lista.buscar(15).getInfo());

		System.out.println("Buscar o nº 50: " + lista.buscar(50));

		lista.retirar(20);
		System.out.println("Após remover o nº 20: " + lista);

		lista.retirar(15);
		System.out.println("Após remover o nº 15: " + lista);

		System.out.println("No 1º posição(0): " + lista.obterNo(0).getInfo());

		System.out.println("Última posição: " + lista.obterNo(lista.obterComprimento() - 1).getInfo());

		ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
		System.out.println("Comprimento da lista vazia: " + lista2.obterComprimento());

		System.out.println("Comprimento da lista: " + lista.obterComprimento());
	}
}
