import java.util.ArrayList;
import java.util.List;

public abstract class Atendimento implements Resgistravel, Pagavel {
    private static int contador = 1;
    private int id;
    private String data;
    private String descricao;
    private Veterinario veterinario;
    private List<Procedimento> procedimentos;

    public Atendimento(String data, String descricao, Veterinario veterinario) {
        this.id = contador++;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
        this.procedimentos = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }

    public List<Procedimento> getProcedimentos() { return procedimentos; }

    public void adicionarProcedimento(Procedimento p) {
        procedimentos.add(p);
    }

    public double calcularCustoTotal() {
        double total = 0;
        for (Procedimento p : procedimentos) {
            total += p.getCusto();
        }
        return total;
    }

    // 🔹 Método abstrato exigido pela atividade
    public abstract double calcularValor();

    public void exibirResumo() {
        System.out.println("=== ATENDIMENTO Nº " + id + " ===");
        System.out.println("Data: " + data);
        System.out.println("Descrição: " + descricao);
        System.out.println("Veterinário: " + veterinario.getNome());
        System.out.println("Custo base de procedimentos: R$ " + calcularCustoTotal());
        System.out.println("Valor final: R$ " + calcularValor());
        System.out.println("===============================");
    }

    // Interface Registravel
    @Override
    public void registrarNoSistema() {
        System.out.println("Atendimento nº " + id + " registrado com sucesso.");
    }

    // toString (mantendo seu estilo)
    @Override
    public String toString() {
        return "Atendimento{" +
                "data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", veterinario=" + veterinario.getNome() +
                ", procedimentos=" + procedimentos.size() +
                '}';
    }
}
