public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    // a) Construtor
    public ListaDupla() {
        primeiro = null;
    }

    // b) Getter
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    // c) Inserir (no início, como pedido no teste)
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
            novo.setProximo(primeiro);
        }

        primeiro = novo;
    }

    // d) Buscar
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    // e) Retirar
    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

        if (atual == null) return;

        // Se for o primeiro
        if (atual == primeiro) {
            primeiro = atual.getProximo();
            if (primeiro != null) {
                primeiro.setAnterior(null);
            }
        } else {
            NoListaDupla<T> ant = atual.getAnterior();
            NoListaDupla<T> prox = atual.getProximo();

            if (ant != null) {
                ant.setProximo(prox);
            }

            if (prox != null) {
                prox.setAnterior(ant);
            }
        }

        // Limpar referências
        atual.setAnterior(null);
        atual.setProximo(null);
    }

    // f) Exibir inverso
    public void exibirOrdemInversa() {
        if (primeiro == null) return;

        NoListaDupla<T> atual = primeiro;

        // Vai até o último
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        // Volta exibindo
        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    // g) Liberar
    public void liberar() {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            NoListaDupla<T> prox = atual.getProximo();

            atual.setAnterior(null);
            atual.setProximo(null);

            atual = prox;
        }

        primeiro = null;
    }

    // h) toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());

            if (atual.getProximo() != null) {
                sb.append(", ");
            }

            atual = atual.getProximo();
        }

        return sb.toString();
    }
}