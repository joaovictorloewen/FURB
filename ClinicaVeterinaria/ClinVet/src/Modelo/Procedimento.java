package Modelo;

public class Procedimento {
    private String nome;
    private double custo;
    private String observacoes;

    public Procedimento(String nome, double custo, String observacoes) {
        this.nome = nome;
        this.custo = custo;
        this.observacoes = observacoes;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getCusto() { return custo; }
    public void setCusto(double custo) { this.custo = custo; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String exibirDados() {
        return "Procedimento: " + nome + " | Custo: R$" + custo + " | Obs: " + observacoes;
    }
}
