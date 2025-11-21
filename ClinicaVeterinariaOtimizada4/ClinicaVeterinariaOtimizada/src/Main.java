import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Clínica Veterinária ===");

        System.out.print("Informe o nome do tutor: ");
        String nomeTutor = sc.nextLine();
        System.out.print("Informe o telefone do tutor: ");
        String telefoneTutor = sc.nextLine();
        System.out.print("Informe o endereço do tutor: ");
        String enderecoTutor = sc.nextLine();

        Tutor tutor = new Tutor(nomeTutor, telefoneTutor, enderecoTutor);

        System.out.print("\nInforme o nome do animal: ");
        String nomeAnimal = sc.nextLine();
        System.out.print("Informe a espécie do animal: ");
        String especieAnimal = sc.nextLine();
        System.out.print("Informe a idade do animal: ");
        int idadeAnimal = sc.nextInt();
        sc.nextLine();

        Animal animal = new Animal(nomeAnimal, especieAnimal, idadeAnimal, tutor);
        tutor.addAnimal(animal);

        System.out.print("\nDigite uma descrição para o histórico do animal: ");
        String hist = sc.nextLine();
        animal.adicionarHistorico(hist);

        System.out.println("\n--- Cadastro de Veterinário ---");
        System.out.print("Nome do veterinário: ");
        String nomeVet = sc.nextLine();
        System.out.print("CRMV: ");
        String crmv = sc.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();
        System.out.print("CPF do veterinário: ");
        String cpfVet = sc.nextLine();

        Veterinario veterinario = new Veterinario(nomeVet, cpfVet, crmv, especialidade);

        System.out.println("\n--- Novo Atendimento ---");
        System.out.print("Data do atendimento (DD/MM/AAAA): ");
        String dataAtendimento = sc.nextLine();
        System.out.print("Descrição do atendimento: ");
        String descricaoAtendimento = sc.nextLine();
        
        // Substituído Atendimento (abstrata) por AtendimentoEmergencia
        Atendimento atendimento = new AtendimentoEmergencia(dataAtendimento, descricaoAtendimento, veterinario, 1);
        animal.adicionarAtendimento(atendimento);

        System.out.println("\n--- Procedimentos do Atendimento ---");
        char continuar = 's';
        while (continuar == 's' || continuar == 'S') {
            System.out.print("Nome do procedimento: ");
            String nomeProc = sc.nextLine();
            System.out.print("Custo do procedimento: ");
            double custoProc = sc.nextDouble();
            sc.nextLine();
            System.out.print("Observações: ");
            String obsProc = sc.nextLine();
            
            Procedimento procedimento = new Procedimento(nomeProc, custoProc, obsProc);
            atendimento.adicionarProcedimento(procedimento);
            
            System.out.print("Deseja adicionar outro procedimento? (s/n): ");
            continuar = sc.nextLine().charAt(0);
        }

        System.out.println("\n--- Dados Cadastrados ---");
        System.out.println(tutor);
        System.out.println(animal);
        System.out.println("Histórico: " + animal.getHistorico());
        System.out.println("\n" + veterinario.retornaDados());
        System.out.println("\n--- Detalhes do Atendimento ---");
        atendimento.exibirResumo();
        System.out.println("Total gasto com o animal: R$ " + 
                          String.format("%.2f", animal.calcularTotalGastos()));
        System.out.println("Total gasto pelo tutor: R$ " + 
                          String.format("%.2f", tutor.calcularTotalGastos()));
        
        // Substituição do Atendimento comum por Emergência/Retorno
        Atendimento consulta1 = new AtendimentoEmergencia("10/09/2025", "Consulta de rotina", veterinario, 2);
        AtendimentoEmergencia emergencia = new AtendimentoEmergencia("11/09/2025", "Acidente doméstico", veterinario, 5);
        AtendimentoRetorno retorno = new AtendimentoRetorno("15/09/2025", "Retorno após tratamento", veterinario, consulta1);

        System.out.println("\n--- Testando registrar() com herança ---");
        consulta1.registrarNoSistema();
        emergencia.registrarNoSistema();
        retorno.registrarNoSistema();
        
        System.out.println("\n--- Testando getResumo() ---");
        System.out.println(tutor.getResumo());
        System.out.println(veterinario.getResumo());
        
        Atendimento consultaExtra1 = new AtendimentoEmergencia("10/09/2025", "Acidente doméstico", veterinario, 3);
        Atendimento consultaExtra2 = new AtendimentoRetorno("15/09/2025", "Revisão pós-tratamento", veterinario, consultaExtra1);

        consultaExtra1.adicionarProcedimento(new Procedimento("Curativo", 80, "Sem complicações"));
        consultaExtra2.adicionarProcedimento(new Procedimento("Avaliação final", 60, "Animal recuperado"));

        List<Atendimento> atendimentos = new ArrayList<>();
        atendimentos.add(consultaExtra1);
        atendimentos.add(consultaExtra2);

        System.out.println("\n=== POLIMORFISMO EM ATENDIMENTOS ===");
        for (Atendimento a : atendimentos) {
            a.exibirResumo();
            System.out.println(a.getDescricaoPagamento());
        }

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(tutor);
        pessoas.add(veterinario);

        System.out.println("\n=== POLIMORFISMO EM PESSOAS ===");
        for (Pessoa p : pessoas) {
            System.out.println(p.getResumo());
        }

        sc.close();
    }
}
