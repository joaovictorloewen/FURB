package pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int topo;

    @SuppressWarnings("unchecked")
    public PilhaVetor(int capacidade) {
        info = (T[]) new Object[capacidade];
        topo = -1;
    }

    public void push(T valor) {
        if (topo == info.length - 1) {
            throw new PilhaCheiaException("Pilha cheia!");
        }
        info[++topo] = valor;
    }

    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        return info[topo--];
    }

    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        return info[topo];
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void liberar() {
        topo = -1;
    }

    public void concatenar(Pilha<T> p) {

        PilhaVetor<T> outra = (PilhaVetor<T>) p;

        int total = (topo + 1) + (outra.topo + 1);
        if (total > info.length) {
            throw new PilhaCheiaException("Sem espaço!");
        }

        for (int i = 0; i <= outra.topo; i++) {
            this.push(outra.info[i]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = topo; i >= 0; i--) {
            sb.append(info[i]);
            if (i > 0) sb.append(",");
        }

        return sb.toString();
    }
}