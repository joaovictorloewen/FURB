package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private Tutor tutor; // obrigatoriamente 1 tutor
    private List<Atendimento> atendimentos;

    public Animal(String nome, String especie, String raca, int idade, Tutor tutor) {
        if (tutor == null) throw new IllegalArgumentException("Animal precisa de um Tutor.");
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.atendimentos = new ArrayList<>();
        this.tutor = tutor;
        // adiciona este animal à lista do tutor (evita duplicação)
        if (!tutor.getAnimais().contains(this)) {
            tutor.adicionarAnimal(this);
        }
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public Tutor getTutor() { return tutor; }

    // Método package-private / protegido para ser usado por Tutor.adicionarAnimal/removerAnimal
    void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    // Atendimentos (0..*)
    public void adicionarAtendimento(Atendimento atendimento) {
        if (atendimento != null && !atendimentos.contains(atendimento)) {
            atendimentos.add(atendimento);
        }
    }

    public void removerAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
    }

    public List<Atendimento> getAtendimentos() {
        return new ArrayList<>(atendimentos);
    }

    public String retornaDados() {
        return "Animal: " + nome + " | Espécie: " + especie + " | Raça: " + raca + " | Idade: " + idade + " | Tutor: " + (tutor != null ? tutor.getNome() : "—");
    }
}
