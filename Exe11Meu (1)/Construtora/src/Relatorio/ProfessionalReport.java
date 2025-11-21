package Relatorio;

import Modelo.Projeto;
import Modelo.Profissional;
import java.util.List;

public class ProfessionalReport implements Report {
    private String idProfissional;

    public ProfessionalReport(String idProfissional) {
        this.idProfissional = idProfissional;
    }

    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder("=== RELATÓRIO POR PROFISSIONAL ===\n");
        for (Projeto p : projetos) {
            for (Profissional pr : p.getProfissionais()) {
                if (pr.getId().equalsIgnoreCase(idProfissional)) {
                    sb.append(pr).append(" -> ").append(p).append("\n");
                }
            }
        }
        return sb.toString();
    }
}
