package Relatorio;

import Modelo.Projeto;
import java.util.List;

public interface Report {
    String gerar(List<Projeto> projetos);
}
