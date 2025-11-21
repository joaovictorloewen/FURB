package Modelo;

public class Profissional {
    private String id;
    private String cpf;
    private String nome;

    public Profissional(String id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getId() { return id; }
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return String.format("[%s] %s (CPF: %s)", id, nome, cpf);
    }
}
