public class AtendimentoRetorno extends Atendimento {
    private Atendimento atendimentoAnterior;

    public AtendimentoRetorno(String data, String descricao, Veterinario veterinario, Atendimento atendimentoAnterior) {
        super(data, descricao, veterinario);
        this.atendimentoAnterior = atendimentoAnterior;
    }

    public Atendimento getAtendimentoAnterior() {
        return atendimentoAnterior;
    }

    public void setAtendimentoAnterior(Atendimento atendimentoAnterior) {
        this.atendimentoAnterior = atendimentoAnterior;
    }

    // Valor = 50% do valor dos procedimentos
    @Override
    public double calcularValor() {
        return calcularCustoTotal() * 0.5;
    }

    @Override
    public double getValorTotal() {
        return calcularValor();
    }

    @Override
    public String getDescricaoPagamento() {
        return "Pagamento de RETORNO com 50% de desconto: R$ " + calcularValor();
    }

    @Override
    public void registrarNoSistema() {
        System.out.println("Atendimento de RETORNO nº " + getId() + " registrado no sistema!");
    }
}
