package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfissionalTest {

    @Test
    public void testConstrutorEGetters() {
        Profissional prof = new Profissional("P01", "123.456.789-00", "João da Silva");

        assertEquals("P01", prof.getId());
        assertEquals("123.456.789-00", prof.getCpf());
        assertEquals("João da Silva", prof.getNome());
    }

    @Test
    public void testToStringFormatoCorreto() {
        Profissional prof = new Profissional("P02", "987.654.321-00", "Maria Souza");

        String texto = prof.toString();
        assertTrue(texto.contains("P02"));
        assertTrue(texto.contains("Maria Souza"));
        assertTrue(texto.contains("987.654.321-00"));
        assertEquals("[P02] Maria Souza (CPF: 987.654.321-00)", texto);
    }

    @Test
    public void testValoresNulosOuVazios() {
        Profissional prof = new Profissional("", "", "");

        assertEquals("", prof.getId());
        assertEquals("", prof.getCpf());
        assertEquals("", prof.getNome());
        assertEquals("[]  (CPF: )", prof.toString());
    }
}
