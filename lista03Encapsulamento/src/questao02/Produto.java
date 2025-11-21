package questao02;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        setPreco(preco);
        this.estoque = estoque;
    }

    public boolean vender(int quantidade) {
        if (quantidade > 0 && quantidade <= estoque) {
            estoque -= quantidade;
            return true;
        }
        return false;
    }

    public void repor(int quantidade) {
        if (quantidade > 0) {
            estoque += quantidade;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
    }

    public int getEstoque() {
        return estoque;
    }
}
