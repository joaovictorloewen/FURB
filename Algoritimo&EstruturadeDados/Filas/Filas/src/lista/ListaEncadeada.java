package lista;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> fim;

    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserirNoFinal(T dado) {
        No<T> novo = new No<>(dado);

        if (estaVazia()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public T removerInicio() {
        if (estaVazia()) return null;

        T valor = inicio.dado;
        inicio = inicio.proximo;

        if (inicio == null) fim = null;

        return valor;
    }

    public T getInicio() {
        return inicio != null ? inicio.dado : null;
    }

    public void limpar() {
        inicio = fim = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = inicio;

        while (atual != null) {
            sb.append(atual.dado);
            if (atual.proximo != null) sb.append(",");
            atual = atual.proximo;
        }

        return sb.toString();
    }
}