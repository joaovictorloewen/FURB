public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        }

        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String texto = "<" + no.getInfo();

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            texto += obterRepresentacaoTextual(filho);
            filho = filho.getProximo();
        }

        texto += ">";

        return texto;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }

        if (no.getInfo().equals(info)) {
            return true;
        }

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }

            filho = filho.getProximo();
        }

        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }

        int quantidade = 1;

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            quantidade += contarNos(filho);
            filho = filho.getProximo();
        }

        return quantidade;
    }
}