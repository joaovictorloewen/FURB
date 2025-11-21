package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ProjetoPublicoTest {

    @Test
    public void testConstrutorEGetters() {
        LocalDate entrada = LocalDate.of(2025, 1, 10);
        LocalDate inicio = LocalDate.of(2025, 2, 15);
        LocalDate fim = LocalDate.of(2025, 12, 20);

        ProjetoPublico projeto = new ProjetoPublico(
                "PUB001",
                entrada,
                "Construção de escola municipal",
                inicio,
                fim,
                "Prefeitura de Blumenau"
        );

        assertNotNull(projeto);
        assertEquals("Público", projeto.getTipo());
        assertEquals("PUB001", projeto.getId());
        assertEquals("Construção de escola municipal", projeto.getDescricao());
        assertEquals(entrada, projeto.getDataEntrada());
        assertEquals(inicio, projeto.getDataInicio());
        assertEquals(fim, projeto.getDataFim());
    }

    @Test
    public void testToStringContemInformacoesCorretas() {
        ProjetoPublico projeto = new ProjetoPublico(
                "PUB002",
                LocalDate.of(2025, 3, 1),
                "Reforma de hospital",
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2026, 1, 15),
                "Ministério da Saúde"
        );

        String texto = projeto.toString();
        assertTrue(texto.contains("PUB002"));
        assertTrue(texto.contains("Reforma de hospital"));
        assertTrue(texto.contains("Ministério da Saúde"));
        assertTrue(texto.contains("Público") || texto.contains("Órgão"));
    }

    @Test
    public void testToStringComOrgaoNuloOuVazio() {
        ProjetoPublico projeto = new ProjetoPublico(
                "PUB003",
                LocalDate.now(),
                "Obra sem órgão definido",
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                ""
        );

        String texto = projeto.toString();
        assertTrue(texto.contains("Obra sem órgão definido"));
        assertTrue(texto.contains("Órgão:"));
    }
}
