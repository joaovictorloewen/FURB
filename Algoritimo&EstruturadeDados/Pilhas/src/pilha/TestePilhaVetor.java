package pilha;

public class TestePilhaVetor {

    public static void main(String[] args) {

        Pilha<Integer> p = new PilhaVetor<>(5);

        System.out.println(p.estaVazia()); // true

        p.push(10);
        System.out.println(p.estaVazia()); // false

        p.push(20);
        p.push(30);

        System.out.println(p.pop()); // 30
        System.out.println(p.pop()); // 20
        System.out.println(p.pop()); // 10

        System.out.println(p.estaVazia()); // true

        // Teste exceção
        try {
            p.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}