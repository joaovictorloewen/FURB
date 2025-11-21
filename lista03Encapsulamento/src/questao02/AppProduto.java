package questao02;

public class AppProduto {
    public static void main(String[] args) {
        Produto p = new Produto("Notebook", 3500.0, 10);

        System.out.println("Estoque inicial: " + p.getEstoque());

        p.vender(3);
        System.out.println("Estoque após venda: " + p.getEstoque());

        p.repor(5);
        System.out.println("Estoque após reposição: " + p.getEstoque());

        p.setPreco(-100);
        System.out.println("Preço atual: " + p.getPreco());
    }
}
