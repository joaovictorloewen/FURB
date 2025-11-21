package Modelo;

import java.time.LocalDate;
import java.util.List;

public class AtendimentoRetorno extends Atendimento implements Registravel {
	private Atendimento AtendimentoAnterior;

	public Atendimento getAtendimentoAnterior() {
		return AtendimentoAnterior;
	}

	public void setAtendimentoAnterior(Atendimento atendimentoAnterior) {
		AtendimentoAnterior = atendimentoAnterior;
	}
	
	public AtendimentoRetorno(int id, LocalDate data, String descricao, Veterinario veterinario, Animal animal,
			List<Procedimento> procedimentos, Atendimento atendimentoAnterior) {
		super(id, data, descricao, veterinario, animal, procedimentos);
		AtendimentoAnterior = atendimentoAnterior;
	}

	public void registrar() {
    	System.out.println("Consulta de retorno registrada para" + getAnimal().getNome() + 
    			"\nReferente à consulta\r\n" + "anterior em " + getData());
    }

	@Override
	double calcularValor() {
		double total = 250 / 2;
		System.out.println("O valor do retorno é de: " + total);
		return total;
	}
	@Override
	public void registrarNoSistema() {
		System.out.println("Atendimento nº " + getId() + "registrado com sucesso");
	}
}
