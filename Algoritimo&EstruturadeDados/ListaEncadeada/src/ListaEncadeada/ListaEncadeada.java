package ListaEncadeada;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T info) {

        if (estaVazia()) {
            return;
        }

        if (primeiro.getInfo().equals(info)) {
            primeiro = primeiro.getProximo();
            return;
        }

        NoLista<T> anterior = primeiro;
        NoLista<T> atual = primeiro.getProximo();

        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                anterior.setProximo(atual.getProximo());
                return;
            }

            anterior = atual;
            atual = atual.getProximo();
        }
    }
    
    public int obterComprimento() {

        int contador = 0;
        NoLista<T> atual = primeiro;

        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }

        return contador;
    }

    public NoLista<T> obterNo(int pos) {

        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> atual = primeiro;
        int indice = 0;

        while (atual != null) {

            if (indice == pos) {
                return atual;
            }

            indice++;
            atual = atual.getProximo();
        }

        throw new IndexOutOfBoundsException();
    }

    public String toString() {

        String resultado = "";

        NoLista<T> atual = primeiro;

        while (atual != null) {

            resultado += atual.getInfo();

            if (atual.getProximo() != null) {
                resultado += ", ";
            }

            atual = atual.getProximo();
        }

        return resultado;
    }
}
