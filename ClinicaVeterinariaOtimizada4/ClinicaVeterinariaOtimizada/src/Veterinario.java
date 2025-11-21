public class Veterinario extends Pessoa {
    private String crmv;
    private String especialidade;
    private Veterinario supervisor;

    public Veterinario(String nome, String cpf, String crmv, String especialidade) {
        super(nome, cpf);
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.supervisor = null;
    }

    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public Veterinario getSupervisor() { return supervisor; }
    public void setSupervisor(Veterinario supervisor) { this.supervisor = supervisor; }

    @Override
    public String getResumo() {
        return getNome() + " é Veterinário - CRMV: " + crmv + ", Especialidade: " + especialidade;
    }

    public String retornaDados() {
        String dados = "Veterinário: " + getNome() +
                      "\nCRMV: " + crmv +
                      "\nEspecialidade: " + especialidade;

        if (supervisor != null) {
            dados += "\nSupervisor: " + supervisor.getNome() + " (CRMV: " + supervisor.getCrmv() + ")";
        } else {
            dados += "\nSupervisor: Não possui";
        }
        return dados;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
               "nome='" + getNome() + '\'' +
               ", crmv='" + crmv + '\'' +
               ", especialidade='" + especialidade + '\'' +
               '}';
    }
}
