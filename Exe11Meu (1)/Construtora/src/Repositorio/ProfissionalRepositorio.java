package Repositorio;

import Modelo.Profissional;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalRepositorio {
    private List<Profissional> lista = new ArrayList<>();

    public void adicionar(Profissional p) { lista.add(p); }
    public List<Profissional> todos() { return lista; }

    public Profissional buscarPorId(String id) {
        return lista.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
