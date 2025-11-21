package Relatorio;

public class ReportFactory {
    public static Report criarCompleto() { return new CompleteReport(); }
    public static Report criarTipo(Class<?> tipo) { return new TypeReport(tipo); }
    public static Report criarProfissional(String id) { return new ProfessionalReport(id); }
    public static Report criarResumo() { return new SummaryReport(); }
}

