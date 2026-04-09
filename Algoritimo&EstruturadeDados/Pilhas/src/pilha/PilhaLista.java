package pilha;

public class PilhaLista<T> implements Pilha<T> {

    private NoLista<T> topo;

    public void push(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.info = valor;
        novo.proximo = topo;
        topo = novo;
    }

    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        T valor = topo.info;
        topo = topo.proximo;
        return valor;
    }

    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        return topo.info;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void liberar() {
        topo = null;
    }

    public void concatenar(Pilha<T> p) {

        Pilha<T> aux = new PilhaLista<>();

        while (!p.estaVazia()) {
            aux.push(p.pop());
        }

        while (!aux.estaVazia()) {
            T valor = aux.pop();
            this.push(valor);
            p.push(valor);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = topo;

        while (atual != null) {
            sb.append(atual.info);
            if (atual.proximo != null) sb.append(",");
            atual = atual.proximo;
        }

        return sb.toString();
    }
}