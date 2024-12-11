package model;
import repository.PacienteRepository;
import repository.DentistaRepository;
import repository.ConsultaRepository;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criação dos repositórios
        PacienteRepository pacienteRepo = new PacienteRepository();
        DentistaRepository dentistaRepo = new DentistaRepository();
        ConsultaRepository consultaRepo = new ConsultaRepository();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Consulta Odontológica ===");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Dentista");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Listar Dentistas");
            System.out.println("6. Listar Consultas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    // Adicionar Paciente
                    System.out.print("Nome do Paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    System.out.print("Telefone do Paciente: ");
                    String telefonePaciente = scanner.nextLine();
                    System.out.print("Email do Paciente: ");
                    String emailPaciente = scanner.nextLine();
                    System.out.print("Endereço do Paciente: ");
                    String enderecoPaciente = scanner.nextLine();
                    System.out.print("Data de Nascimento do Paciente: ");
                    String dataNascimentoPaciente = scanner.nextLine();

                    Paciente paciente = new Paciente(nomePaciente, cpfPaciente, telefonePaciente, emailPaciente, enderecoPaciente, dataNascimentoPaciente);
                    pacienteRepo.adicionarPaciente(paciente);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;

                case 2:
                    // Adicionar Dentista
                    System.out.print("Nome do Dentista: ");
                    String nomeDentista = scanner.nextLine();
                    System.out.print("CRM do Dentista: ");
                    String crmDentista = scanner.nextLine();
                    System.out.print("Telefone do Dentista: ");
                    String telefoneDentista = scanner.nextLine();
                    System.out.print("Email do Dentista: ");
                    String emailDentista = scanner.nextLine();

                    Dentista dentista = new Dentista(nomeDentista, crmDentista, telefoneDentista, emailDentista);
                    dentistaRepo.adicionarDentista(dentista);
                    System.out.println("Dentista adicionado com sucesso!");
                    break;

                case 3:
                    // Agendar Consulta
                    System.out.print("Nome do Paciente: ");
                    String nomePacienteConsulta = scanner.nextLine();
                    Paciente pacienteConsulta = null;
                    for (Paciente p : pacienteRepo.listarPacientes()) {
                        if (p.getNome().equalsIgnoreCase(nomePacienteConsulta)) {
                            pacienteConsulta = p;
                            break;
                        }
                    }

                    if (pacienteConsulta == null) {
                        System.out.println("Paciente não encontrado!");
                        break;
                    }

                    System.out.print("Nome do Dentista: ");
                    String nomeDentistaConsulta = scanner.nextLine();
                    Dentista dentistaConsulta = null;
                    for (Dentista d : dentistaRepo.listarDentistas()) {
                        if (d.getNome().equalsIgnoreCase(nomeDentistaConsulta)) {
                            dentistaConsulta = d;
                            break;
                        }
                    }

                    if (dentistaConsulta == null) {
                        System.out.println("Dentista não encontrado!");
                        break;
                    }

                    System.out.print("Descrição da Consulta: ");
                    String descricaoConsulta = scanner.nextLine();
                    Consulta consulta = new Consulta(pacienteConsulta, dentistaConsulta, new Date(), descricaoConsulta);
                    consultaRepo.agendarConsulta(consulta);
                    System.out.println("Consulta agendada com sucesso!");
                    break;

                case 4:
                    // Listar Pacientes
                    System.out.println("\nPacientes:");
                    for (Paciente p : pacienteRepo.listarPacientes()) {
                        System.out.println(p.getNome());
                    }
                    break;

                case 5:
                    // Listar Dentistas
                    System.out.println("\nDentistas:");
                    for (Dentista d : dentistaRepo.listarDentistas()) {
                        System.out.println(d.getNome());
                    }
                    break;

                case 6:
                    // Listar Consultas
                    System.out.println("\nConsultas:");
                    for (Consulta c : consultaRepo.listarConsultas()) {
                        System.out.println("Paciente: " + c.getPaciente().getNome() + ", Dentista: " + c.getDentista().getNome() + ", Descrição: " + c.getDescricao());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
                   