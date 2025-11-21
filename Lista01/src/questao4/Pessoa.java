package questao4;

public class Pessoa {
    private String nome;
    private double altura;
    private double peso;

    public Pessoa(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    public double calcularImc() {
        return peso / (altura * altura);
    }

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}

