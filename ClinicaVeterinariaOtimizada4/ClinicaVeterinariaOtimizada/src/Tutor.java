import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {
    private String telefone;
    private String endereco;
    private List<Animal> animais;

    public Tutor(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf);
        setTelefone(telefone);
        setEndereco(endereco);
        this.animais = new ArrayList<>();
    }

    public Tutor(String nome, String cpf, String telefone) {
        super(nome, cpf);
        setTelefone(telefone);
        this.endereco = "";
        this.animais = new ArrayList<>();
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone do tutor é obrigatório.");
        }
        this.telefone = telefone.trim();
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) {
        this.endereco = endereco == null ? "" : endereco.trim();
    }

    public List<Animal> getAnimais() { return animais; }
    public void addAnimal(Animal animal) {
        animais.add(animal);
        animal.setTutor(this);
    }

    public int getQuantidadeAnimais() {
        return animais.size();
    }

    public double calcularTotalGastos() {
        double total = 0;
        for (Animal animal : animais) {
            total += animal.calcularTotalGastos();
        }
        return total;
    }

    @Override
    public String getResumo() {
        return getNome() + " é Tutor de " + getQuantidadeAnimais() + " animais.";
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "nome='" + getNome() + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", animais=" + animais.size() +
                '}';
    }
}
