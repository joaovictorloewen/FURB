package pilha;

public class TestePilhaLista {

    public static void main(String[] args) {

        Pilha<Integer> p = new PilhaLista<>();

        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println(p.pop()); // 30
        System.out.println(p.pop()); // 20
        System.out.println(p.pop()); // 10

        System.out.println(p.estaVazia()); // true

        // Teste expressão
        String exp = "10 + [20 / (10 - 20)]";

        if (ValidadorExpressao.validar(exp)) {
            System.out.println("Expressão correta!");
        } else {
            System.out.println("Expressão incorreta!");
        }
    }
}