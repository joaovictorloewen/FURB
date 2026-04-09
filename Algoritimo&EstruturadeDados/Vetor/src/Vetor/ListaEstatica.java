package Vetor;

public class ListaEstatica<T> {

    private T[] info;
    private int tamanho;

    // Construtor
    @SuppressWarnings("unchecked")
    public ListaEstatica() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    // Redimensionar
    @SuppressWarnings("unchecked")
    private void redimensionar() {
        T[] novo = (T[]) new Object[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    // Inserir
    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    // Buscar
    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    // Retirar
    public void retirar(T valor) {
        int pos = buscar(valor);

        if (pos != -1) {
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    // Liberar
    @SuppressWarnings("unchecked")
    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    // Obter elemento
    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        return info[posicao];
    }

    // Está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Getter tamanho
    public int getTamanho() {
        return tamanho;
    }

    // ✅ Método inverter (SEM criar novo vetor)
    public void inverter() {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio < fim) {
            T temp = info[inicio];
            info[inicio] = info[fim];
            info[fim] = temp;

            inicio++;
            fim--;
        }
    }

    // toString
    @Override
    public String toString() {
        if (tamanho == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}