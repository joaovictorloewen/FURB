package questao2;

public class Pessoa {
    private double altura;
    private double peso;

    public Pessoa(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public double calcularImc() {
        return peso / (altura * altura);
    }
}
