package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa implements Registravel {
    private String telefone;
    private String email;
    private List<Animal> animais;

    public Tutor(String nome, String cpf, String telefone, String email, List<Animal> animais) {
		super(nome, cpf);
		this.telefone = telefone;
		this.email = email;
		this.animais = animais;
		this.animais = new ArrayList<>();
	}

    public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}


	// Adicionar animal ao tutor — estabelece associação bidirecional
    public void adicionarAnimal(Animal animal) {
        if (animal == null) return;
        if (!animais.contains(animal)) {
            animais.add(animal);
            animal.setTutor(this);
        }
    }

    // Remover animal do tutor — desassocia (animal precisa tratar o tutor como nulo)
    public void removerAnimal(Animal animal) {
        if (animal == null) return;
        if (animais.remove(animal)) {
            animal.setTutor(null);
        }
    }

    public String retornaDados() {
        return "Tutor: " + getNome() + " | Tel: " + telefone + " | Email: " + email + " | Nº animais: " + animais.size();
    }

	@Override
	public void getResumo() {
		System.out.println("O nome do tutor é: " + getNome() + " ele é um tutor");
	}

	@Override
	public void registrarNoSistema() {
		System.out.println("Tutor registrado com sucesso");
		
	}
}
