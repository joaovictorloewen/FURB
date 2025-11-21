package questao01;

public class AppPessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Maria", 25);
        Pessoa p2 = new Pessoa("João", 30);

        p1.exibirDados();
        p2.exibirDados();

        p1.setIdade(-5);
        p1.setNome("   ");
        p1.exibirDados();
    }
}
