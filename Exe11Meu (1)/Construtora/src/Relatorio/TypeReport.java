package Relatorio;

import Modelo.Projeto;
import java.util.List;

public class TypeReport implements Report {
    private Class<?> tipo;

    public TypeReport(Class<?> tipo) { this.tipo = tipo; }

    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder("=== RELATÓRIO POR TIPO ===\n");
        projetos.stream()
                .filter(p -> p.getClass() == tipo)
                .forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }
}
