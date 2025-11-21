package Questao01;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario() {}

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        setSalario(salario);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) {
        if (salario < 0) {
            System.out.println("Valor inválido");
            this.salario = 0.0;
        } else {
            this.salario = salario;
        }
    }

    public double calcularIrpf() {
        double s = this.salario;
        double imposto = 0.0;

        double[][] faixas = new double[][]{
            {0.00, 1903.98, 0.000},
            {1903.98, 2826.65, 0.075},
            {2826.65, 3751.05, 0.150},
            {3751.05, 4664.68, 0.225},
            {4664.68, Double.POSITIVE_INFINITY, 0.275}
        };

        for (double[] f : faixas) {
            double inicio = f[0];
            double fim = f[1];
            double aliquota = f[2];
            if (s > inicio) {
                double base = (fim == Double.POSITIVE_INFINITY) ?
                        Math.max(0, s - inicio) :
                        Math.max(0, Math.min(s, fim) - inicio);
                imposto += base * aliquota;
            }
            if (s <= fim) break;
        }

        BigDecimal bd = BigDecimal.valueOf(imposto).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}