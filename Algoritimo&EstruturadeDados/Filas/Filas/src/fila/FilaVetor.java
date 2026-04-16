package fila;

import excecoes.FilaCheiaException;
import excecoes.FilaVaziaException;

public class FilaVetor<T> implements Fila<T> {

    private T[] dados;
    private int inicio;
    private int fim;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaVetor(int capacidade) {
        dados = (T[]) new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    @Override
    public void inserir(T dado) throws FilaCheiaException {
        if (tamanho == dados.length) {
            throw new FilaCheiaException("Fila cheia!");
        }
        dados[fim] = dado;
        fim = (fim + 1) % dados.length;
        tamanho++;
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }
        T valor = dados[inicio];
        inicio = (inicio + 1) % dados.length;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }
        return dados[inicio];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            try {
                retirar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getLimite() {
        return dados.length;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> nova = new FilaVetor<>(this.getLimite() + f2.getLimite());

        try {
            // copiar f1
            for (int i = 0; i < this.tamanho; i++) {
                nova.inserir(this.dados[(inicio + i) % dados.length]);
            }

            // copiar f2
            for (int i = 0; i < f2.tamanho; i++) {
                nova.inserir(f2.dados[(f2.inicio + i) % f2.dados.length]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nova;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[(inicio + i) % dados.length]);
            if (i < tamanho - 1) sb.append(",");
        }
        return sb.toString();
    }
}