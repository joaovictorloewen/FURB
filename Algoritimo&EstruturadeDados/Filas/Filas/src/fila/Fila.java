package fila;

import excecoes.FilaCheiaException;
import excecoes.FilaVaziaException;

public interface Fila<T> {
    void inserir(T dado) throws FilaCheiaException;
    T retirar() throws FilaVaziaException;
    T peek() throws FilaVaziaException;
    boolean estaVazia();
    void liberar();
}