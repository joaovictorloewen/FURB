package fila;

import excecoes.FilaVaziaException;
import lista.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T dado) {
        lista.inserirNoFinal(dado);
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }
        return lista.removerInicio();
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }
        return lista.getInicio();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista.limpar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}