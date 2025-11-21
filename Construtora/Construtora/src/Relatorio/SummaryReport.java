package Relatorio;

import Modelo.Projeto;
import Modelo.ProjetoPublico;
import Modelo.ProjetoPrivado;
import java.util.List;

public class SummaryReport implements Report {
    @Override
    public String gerar(List<Projeto> projetos) {
        long total = projetos.size();
        long publicos = projetos.stream().filter(p -> p instanceof ProjetoPublico).count();
        long privados = projetos.stream().filter(p -> p instanceof ProjetoPrivado).count();

        return "=== RELATÓRIO RESUMIDO ===\n" +
                "Total de projetos: " + total + "\n" +
                "Públicos: " + publicos + "\n" +
                "Privados: " + privados + "\n";
    }
}
