package Repositorio;

import Modelo.Projeto;
import java.util.ArrayList;
import java.util.List;

public class ProjetoRepositorio {
    private List<Projeto> lista = new ArrayList<>();

    public void adicionar(Projeto p) { lista.add(p); }
    public List<Projeto> todos() { return lista; }

    public Projeto buscarPorId(String id) {
        return lista.stream()
                .filter(p -> p.toString().contains(id))
                .findFirst()
                .orElse(null);
    }
}
