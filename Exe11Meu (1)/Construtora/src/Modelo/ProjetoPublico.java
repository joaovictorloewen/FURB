package Modelo;

import java.time.LocalDate;

public class ProjetoPublico extends Projeto {
    private String orgaoResponsavel;

    public ProjetoPublico(String id, LocalDate dataEntrada, String descricao,
                          LocalDate dataInicio, LocalDate dataFim, String orgaoResponsavel) {
        super(id, dataEntrada, descricao, dataInicio, dataFim);
        this.orgaoResponsavel = orgaoResponsavel;
    }

    @Override
    public String getTipo() { return "Público"; }

    @Override
    public String toString() {
        return super.toString() + " - Órgão: " + orgaoResponsavel;
    }
}
