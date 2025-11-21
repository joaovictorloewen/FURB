package Modelo;

import java.time.LocalDate;

public class ProjetoPrivado extends Projeto {
    private boolean rural;
    private double area;
    private String localizacao;

    public ProjetoPrivado(String id, LocalDate dataEntrada, String descricao,
                          LocalDate dataInicio, LocalDate dataFim,
                          boolean rural, double area, String localizacao) {
        super(id, dataEntrada, descricao, dataInicio, dataFim);
        this.rural = rural;
        this.area = area;
        this.localizacao = localizacao;
    }

    @Override
    public String getTipo() { return "Privado"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" - Local: %s, Área: %.2f m², %s",
                localizacao, area, rural ? "Rural" : "Urbano");
    }
}
