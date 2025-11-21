package Modelo;

import java.time.LocalDate;
import java.util.List;

public class AtendimentoEmergencia extends Atendimento implements Registravel {
	private int nivelUrgencia;

	public int getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(int nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}
	
	public AtendimentoEmergencia(int id, LocalDate data, String descricao, Veterinario veterinario, Animal animal,
			List<Procedimento> procedimentos, int nivelUrgencia) {
		super(id, data, descricao, veterinario, animal, procedimentos);
		this.nivelUrgencia = nivelUrgencia;
	}

	public void registrar() {
    	System.out.println("Consulta de emergência registrada para : " + getAnimal().getNome() + 
    			"\nUrgencia: " + getNivelUrgencia() + "\nCom o veterinario: " + getVeterinario().getNome());
    }

	@Override
	double calcularValor() {
		double total = 250 + 50;
		System.out.println("O valor total é de 250 + 50 da emergencia totalizando em: " + total);
		return total;
	}
	@Override
	public void registrarNoSistema() {
		System.out.println("Atendimento nº " + getId() + "registrado com sucesso");
	}
	
}
