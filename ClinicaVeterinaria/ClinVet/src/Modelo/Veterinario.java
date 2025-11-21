package Modelo;

public class Veterinario extends Pessoa implements Registravel {
	private String crmv;
	private String especialidade;
	private Veterinario supervisor; // associação reflexiva

	public Veterinario(String nome, String cpf, String crmv, String especialidade, Veterinario supervisor) {
		super(nome, cpf);
		this.crmv = crmv;
		this.especialidade = especialidade;
		this.supervisor = supervisor;
	}

	// Getters e Setters

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Veterinario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Veterinario supervisor) {
		this.supervisor = supervisor;
	}

	public String retornaDados() {
		String info = "Veterinário: " + getNome() + " | CRMV: " + crmv + " | Especialidade: " + especialidade;
		if (supervisor != null)
			info += " | Supervisor: " + supervisor.getNome();
		return info;
	}

	@Override
	public void getResumo() {
		System.out.println("O nome do veterinario é: " + getNome() + "\nSeu CRMV é: " + getCrmv()
				+ "\nSua especialidade é: " + getEspecialidade());
	}

	@Override
	public void registrarNoSistema() {
		System.out.println("Veterinário registrado com CRMV válido");
		
	}
}
