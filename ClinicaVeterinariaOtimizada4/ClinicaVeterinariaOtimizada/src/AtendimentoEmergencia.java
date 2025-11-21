public class AtendimentoEmergencia extends Atendimento {
    private int nivelUrgencia;
    private double taxaEmergencia = 100.0; // valor base fixo só de exemplo

    public AtendimentoEmergencia(String data, String descricao, Veterinario veterinario, int nivelUrgencia) {
        super(data, descricao, veterinario);
        this.nivelUrgencia = nivelUrgencia;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    // Valor = custo procedimentos + taxa base * nível de urgência
    @Override
    public double calcularValor() {
        return calcularCustoTotal() + (taxaEmergencia * nivelUrgencia);
    }

    @Override
    public double getValorTotal() {
        return calcularValor();
    }

    @Override
    public String getDescricaoPagamento() {
        return "Pagamento de EMERGÊNCIA (Nível " + nivelUrgencia + "): R$ " + calcularValor();
    }

    @Override
    public void registrarNoSistema() {
        System.out.println("Atendimento de EMERGÊNCIA nº " + getId() + " registrado no sistema!");
    }
}
