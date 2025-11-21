import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private final List<String> historico;
    private Tutor tutor;
    private List<Atendimento> atendimentos; // Nova lista de atendimentos
    
    public Animal(String nome, String especie, int idade, Tutor tutor) {
        setNome(nome);
        setEspecie(especie);
        setIdade(idade);
        setTutor(tutor);
        this.historico = new ArrayList<>();
        this.atendimentos = new ArrayList<>(); // Inicializa a nova lista
    }
    
    public Animal(String nome, String especie) {
        setNome(nome);
        setEspecie(especie);
        this.idade = 0;
        this.tutor = null;
        this.historico = new ArrayList<>();
        this.atendimentos = new ArrayList<>(); // Inicializa a nova lista
    }
    
    // Métodos existentes mantidos...
    public String getNome() { return nome; }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do animal não pode ser vazio.");
        }
        this.nome = nome.trim();
    }
    
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) {
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("Espécie do animal não pode ser vazia.");
        }
        this.especie = especie.trim();
    }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade do animal não pode ser negativa.");
        }
        this.idade = idade;
    }
    
    public Tutor getTutor() { return tutor; }
    public void setTutor(Tutor tutor) { this.tutor = tutor; }
    
    public void adicionarHistorico(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do histórico não pode ser vazia.");
        }
        String timestamp = java.time.LocalDateTime.now().toString();
        historico.add("[" + timestamp + "] " + descricao.trim());
    }
    
    public List<String> getHistorico() {
        return Collections.unmodifiableList(historico);
    }
    
    // NOVOS MÉTODOS PARA ATENDIMENTOS
    public List<Atendimento> getAtendimentos() { 
        return Collections.unmodifiableList(atendimentos); 
    }
    
    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        // Adiciona também ao histórico
        adicionarHistorico("Atendimento em " + atendimento.getData() + 
                          " por " + atendimento.getVeterinario().getNome() + 
                          ": " + atendimento.getDescricao());
    }
    
    public double calcularTotalGastos() {
        double total = 0;
        for (Atendimento atendimento : atendimentos) {
            total += atendimento.calcularCustoTotal();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idade +
                ", tutor=" + (tutor != null ? tutor.getNome() : "sem tutor") +
                ", atendimentos=" + atendimentos.size() +
                '}';
    }
}