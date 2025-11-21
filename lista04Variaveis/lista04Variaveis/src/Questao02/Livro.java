package Questao02;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    private static int totalLivros = 0;

    public Livro() {
        this("Sem título", "Desconhecido", 0);
    }

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        totalLivros++;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacao() { return anoPublicacao; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnoPublicacao(int ano) { this.anoPublicacao = ano; }

    public String exibirInfo() {
        return String.format("Título: %s | Autor: %s | Ano: %d",
                titulo, autor, anoPublicacao);
    }

    public String exibirInfo(boolean resumido) {
        return resumido ? "Título: " + titulo : exibirInfo();
    }

    public static int getTotalLivros() {
        return totalLivros;
    }
}