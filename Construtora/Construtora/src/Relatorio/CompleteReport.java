package Relatorio;

import Modelo.Projeto;
import Modelo.Profissional;
import java.util.List;

public class CompleteReport implements Report {
    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder("=== RELATÓRIO COMPLETO ===\n");
        for (Projeto p : projetos) {
            sb.append(p).append("\n");
            for (Profissional pr : p.getProfissionais()) {
                sb.append("   - ").append(pr).append("\n");
            }
        }
        return sb.toString();
    }
}
