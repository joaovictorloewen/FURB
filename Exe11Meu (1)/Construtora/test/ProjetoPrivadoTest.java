package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ProjetoPrivadoTest {

    @Test
    public void testConstrutorEGetters() {
        LocalDate entrada = LocalDate.of(2025, 1, 10);
        LocalDate inicio = LocalDate.of(2025, 2, 1);
        LocalDate fim = LocalDate.of(2025, 6, 30);

        ProjetoPrivado projeto = new ProjetoPrivado(
                "P001",
                entrada,
                "Construção de residência",
                inicio,
                fim,
                true,
                1500.75,
                "Zona Rural"
        );

        assertNotNull(projeto);
        assertEquals("Privado", projeto.getTipo());
        assertEquals("P001", projeto.getId());
        assertEquals("Construção de residência", projeto.getDescricao());
        assertEquals(entrada, projeto.getDataEntrada());
        assertEquals(inicio, projeto.getDataInicio());
        assertEquals(fim, projeto.getDataFim());
    }

    @Test
    public void testToStringRural() {
        ProjetoPrivado projeto = new ProjetoPrivado(
                "P002",
                LocalDate.of(2025, 1, 1),
                "Fazenda Experimental",
                LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 12, 31),
                true,
                2500.0,
                "Interior"
        );

        String texto = projeto.toString();
        assertTrue(texto.contains("Interior"));
        assertTrue(texto.contains("Rural"));
        assertTrue(texto.contains("2500.00"));
    }

    @Test
    public void testToStringUrbano() {
        ProjetoPrivado projeto = new ProjetoPrivado(
                "P003",
                LocalDate.of(2025, 3, 1),
                "Edifício Comercial",
                LocalDate.of(2025, 3, 10),
                LocalDate.of(2026, 1, 1),
                false,
                800.5,
                "Centro"
        );

        String texto = projeto.toString();
        assertTrue(texto.contains("Centro"));
        assertTrue(texto.contains("Urbano"));
        assertTrue(texto.contains("800.50"));
    }
}
