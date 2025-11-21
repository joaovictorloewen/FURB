package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Projeto {
    protected String id;
    protected LocalDate dataEntrada;
    protected String descricao;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected List<Profissional> profissionais = new ArrayList<>();

    public Projeto(String id, LocalDate dataEntrada, String descricao,
                   LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void adicionarProfissional(Profissional p) {
        if (!profissionais.contains(p)) {
            profissionais.add(p);
        }
    }

    public abstract String getTipo();

    public List<Profissional> getProfissionais() { return profissionais; }

    @Override
    public String toString() {
        return String.format("(%s) %s [%s - %s] Profissionais: %d",
                getTipo(), descricao, dataInicio, dataFim, profissionais.size());
    }
}
