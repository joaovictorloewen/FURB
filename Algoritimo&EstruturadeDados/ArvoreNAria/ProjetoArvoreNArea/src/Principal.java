public class Principal {

    public static void main(String[] args) {

        Arvore<Integer> arvore = new Arvore<>();

        NoArvore<Integer> no1 = new NoArvore<>(1);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no10 = new NoArvore<>(10);

        arvore.setRaiz(no1);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);

        no3.inserirFilho(no8);

        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        System.out.println("Representacao textual:");
        System.out.println(arvore.toString());

        System.out.println();

        System.out.println("Pertence 7?");
        System.out.println(arvore.pertence(7));

        System.out.println();

        System.out.println("Pertence 55?");
        System.out.println(arvore.pertence(55));

        System.out.println();

        System.out.println("Quantidade de nos:");
        System.out.println(arvore.contarNos());
    }
}