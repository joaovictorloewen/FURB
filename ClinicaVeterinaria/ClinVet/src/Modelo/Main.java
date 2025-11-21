package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        List<Atendimento> atendimentos = new ArrayList<>();

        Tutor t1 = new Tutor("João", "123.456.789-00", "6636366", "Rua A", null);
        Tutor t2 = new Tutor("Ana", "987.654.321-00", "667788", "Rua B", null);
        Tutor t3 = new Tutor("Carlos", "741.852.963-00", "998877", "Rua C", null);
        Tutor t4 = new Tutor("Luiza", "753.159.852-00", "885544", "Rua D", null);
        Tutor t5 = new Tutor("Pedro", "852.456.123-00", "223344", "Rua E", null);
        
        Veterinario v1 = new Veterinario("Maria", "111.222.333-44", "CRMV-101", "Clínico Geral", null);
        Veterinario v2 = new Veterinario("Roberto", "222.333.444-55", "CRMV-202", "Cirurgião", null);
        Veterinario v3 = new Veterinario("Julia", "333.444.555-66", "CRMV-303", "Dermatologista", null);

        pessoas.add(t1);
        pessoas.add(t2);
        pessoas.add(t3);
        pessoas.add(t4);
        pessoas.add(t5);
        pessoas.add(v1);
        pessoas.add(v2);
        pessoas.add(v3);

        Animal a1 = new Animal("Rex", "Chihuahua", "Cachorro", 2, t1);
        Animal a2 = new Animal("Mimi", "Persa", "Gato", 4, t1);
        Animal a3 = new Animal("Bolt", "Labrador", "Cachorro", 3, t2);
        Animal a4 = new Animal("Nina", "Siamês", "Gato", 1, t3);
        Animal a5 = new Animal("Bob", "Poodle", "Cachorro", 5, t4);

        t1.adicionarAnimal(a1);
        t1.adicionarAnimal(a2);
        t2.adicionarAnimal(a3);
        t3.adicionarAnimal(a4);
        t4.adicionarAnimal(a5);

        Atendimento emergencia = new AtendimentoEmergencia(1, LocalDate.now(), "Cirurgia de emergência", v2, a3, null, 0);
        Atendimento retorno = new AtendimentoRetorno(2, LocalDate.now(), "Consulta de rotina", v1, a1, null, emergencia);

        atendimentos.add(retorno);
        atendimentos.add(emergencia);

        System.out.println("=== Lista de Pessoas ===");
        for (Pessoa p : pessoas) {
            p.getResumo();
        }

        System.out.println("\n=== Lista de Atendimentos ===");
        for (Atendimento a : atendimentos) {
            a.exibirDados();
            a.registrarNoSistema();
            
            System.out.println("----------------------------");
        }
    }
}
