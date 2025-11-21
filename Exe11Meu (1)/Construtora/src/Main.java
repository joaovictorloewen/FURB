import Modelo.*;
import Repositorio.*;
import Relatorio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ProfissionalRepositorio profRepo = new ProfissionalRepositorio();
        ProjetoRepositorio projRepo = new ProjetoRepositorio();

        Profissional p1 = new Profissional("1", "11111111111", "Ana Silva");
        Profissional p2 = new Profissional("2", "22222222222", "Carlos Souza");
        profRepo.adicionar(p1);
        profRepo.adicionar(p2);

        ProjetoPublico pub = new ProjetoPublico("OB01", LocalDate.now(), "Ponte Municipal",
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 8, 1), "Prefeitura de Blumenau");
        ProjetoPrivado pri = new ProjetoPrivado("PR01", LocalDate.now(), "Condomínio Vale Verde",
                LocalDate.of(2025, 3, 1), LocalDate.of(2026, 3, 1), false, 1500.0, "Centro");

        pub.adicionarProfissional(p1);
        pri.adicionarProfissional(p2);

        projRepo.adicionar(pub);
        projRepo.adicionar(pri);

        Report completo = ReportFactory.criarCompleto();
        System.out.println(completo.gerar(projRepo.todos()));

        Report resumo = ReportFactory.criarResumo();
        System.out.println(resumo.gerar(projRepo.todos()));
    }
}
