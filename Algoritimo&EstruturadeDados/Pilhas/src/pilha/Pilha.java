package pilha;

public interface Pilha<T> {

    void push(T valor);

    T pop();

    T peek();

    boolean estaVazia();

    void liberar();

    void concatenar(Pilha<T> p);
}