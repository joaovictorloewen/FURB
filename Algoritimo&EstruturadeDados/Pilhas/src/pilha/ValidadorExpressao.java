package pilha;

public class ValidadorExpressao {

    public static boolean validar(String exp) {

        Pilha<Character> p = new PilhaVetor<>(100);

        for (char c : exp.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                p.push(c);
            } else if (c == ')' || c == ']' || c == '}') {

                if (p.estaVazia()) return false;

                char topo = p.pop();

                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{')) {
                    return false;
                }
            }
        }

        return p.estaVazia();
    }
}