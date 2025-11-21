package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Atendimento implements Registravel {
	private int id;
	private LocalDate data;
	private String descricao;
	private Veterinario veterinario;
	private Animal animal;
	private List<Procedimento> procedimentos;

	public Atendimento(int id, LocalDate data, String descricao, Veterinario veterinario, Animal animal,
			List<Procedimento> procedimentos) {
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.veterinario = veterinario;
		this.animal = animal;
		this.procedimentos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	// --------

	public void adicionarProcedimento(Procedimento p) {
		if (p != null)
			procedimentos.add(p);
	}

	public void removerProcedimento(Procedimento p) {
		procedimentos.remove(p);
	}

	public List<Procedimento> getProcedimentos() {
		return new ArrayList<>(procedimentos);
	}

	public void registrar() {
		System.out.println(
				"Consulta registrada para: " + animal.getNome() + " com o veterinario: " + veterinario.getNome());
	}

	abstract double calcularValor();

	// Exibir dados do atendimento
	public void exibirDados() {
		System.out.println("Data: " + data);
		System.out.println("Descrição: " + descricao);
		System.out.println("Animal: " + animal.getNome() + " (Tutor: " + animal.getTutor().getNome() + ")");
		System.out.println("Veterinário: " + (veterinario != null ? veterinario.getNome() : "—"));
		System.out.println("Procedimentos:");
		if (procedimentos.isEmpty()) {
			System.out.println("  Nenhum procedimento associado.");
		} else {
			for (Procedimento p : procedimentos) {
				System.out.println("  - " + p.exibirDados());
			}
		}
		System.out.println("O resultado é: " + calcularValor());
		System.out.println("----------------------------");
	}

	@Override
	public void registrarNoSistema() {
		System.out.println("Atendimento nº " + getId() + "registrado com sucesso");
	}
}
