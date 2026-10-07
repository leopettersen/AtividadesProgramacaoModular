import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Agenda a = new Agenda();

        while (true) {
            int opc = menu();
            switch (opc) {
                case 'a': opcA(a); break;
                case 'b': opcB(a); break;
                case 'c': opcC(a); break;
                case 'd': opcD(a); break;
                case 'e': opcE(a); break;
                case 'f': opcF(a); break;
                case 'g': break;
                default: System.out.println("Opção inválida");
            }
            if (opc == 'g') {sc.close(); break;}
        }
    }

    public static char menu() {
        System.out.println("");
        System.out.println("----MENU----");
        System.out.println("(a) - Adicionar contato");        
        System.out.println("(b) - Remover contato");
        System.out.println("(c) - Buscar contato por nome");
        System.out.println("(d) - Buscar contato por email");
        System.out.println("(e) - Buscar contato por telefone");
        System.out.println("(f) - Consultar tamanho da Agenda");
        System.out.println("(g) - Finalizar");
        System.out.println("");

        char opc = sc.next().toLowerCase().charAt(0);
        sc.nextLine();

        return opc;
    }

    public static void opcA(Agenda a) {
        System.out.println("Qual o nome do contato? ");
        String nome = sc.nextLine();

        System.out.println("Qual o email do contato? ");
        String email = sc.nextLine();

        System.out.println("Qual o telefone do contato? ");
        String telefone = sc.nextLine();

        System.out.println("Qual o tipo do contato?");
        System.out.println("1 - Emergência");
        System.out.println("2 - Pessoal");
        System.out.println("3 - Profissional");
        int opc = sc.nextInt();
        sc.nextLine();

        if (opc == 1) {
            a.adicionarContato(cadastraEmergencia(nome, email, telefone));
        } else if (opc == 2) {
            a.adicionarContato(cadastraPessoal(nome, email, telefone));
        } else if (opc == 3) {
            a.adicionarContato(cadastraProfissional(nome, email, telefone));
        } else {
            System.out.println("Digite uma opção válida!");
            opcA(a);
        }
    }

    public static Contato cadastraEmergencia(String nome, String email, String telefone) {
        System.out.println("Digite a prioridade do contato (1 a 5): ");
        int p = sc.nextInt();
        sc.nextLine();

        while (p < 1 || p > 5) {
            System.out.println("Prioridade inválida! Digite um valor entre 1 e 5: ");
            p = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Digite uma observação sobre o contato: ");
        String obs = sc.nextLine();

        PrioridadeEmergencia prioridade = PrioridadeEmergencia.values()[p - 1];

        Contato c = new ContatoEmergencia(nome, email, telefone, prioridade , obs);

        return c;
    }

    public static Contato cadastraPessoal(String nome, String email, String telefone) {
        System.out.println("Digite a data de aniversário do contato: ");
        String dataA = sc.nextLine();

        System.out.println("Digite o parentesco do contato: ");
        String parentesco = sc.nextLine();


        Contato c = new ContatoPessoal(nome, email, telefone, dataA, parentesco);

        return c;
    }

    public static Contato cadastraProfissional(String nome, String email, String telefone) {
        System.out.println("Digite a empresa do contato: ");
        String empresa = sc.nextLine();

        System.out.println("Digite o cargo do contato: ");
        String cargo = sc.nextLine();


        Contato c = new ContatoProfissional(nome, email, telefone, empresa, cargo);
        
        return c;
    }

    public static void opcB(Agenda a) {
        System.out.println("Digite o nome do Contato que você deseja excluir: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email do contato que você deseja excluir: ");
        String email = sc.nextLine();

        System.out.println("Digite o telefone do contato que você deseja excluir: ");
        String telefone = sc.nextLine();


        for (Contato c : a.getContatos()) {
            if (c.getNome().equalsIgnoreCase(nome) 
                && c.getEmail().equalsIgnoreCase(email)
                && c.getTelefone().equalsIgnoreCase(telefone)) {
                    System.out.println(a.removeContato(c));
                    return;
                }
        }

        System.out.println("Contato não encontrado!");
    }

    public static void opcC(Agenda a) {
        System.out.println("Digite o nome do contato");
        String nome = sc.nextLine();

        Contato c = a.buscarContatoPorNome(nome);

        if (c != null) {
            if (c instanceof ContatoEmergencia) {
                ContatoEmergencia ce = (ContatoEmergencia) c;
                System.out.println(ce.exibeDados());
            } else if (c instanceof ContatoPessoal) {
                ContatoPessoal cpe = (ContatoPessoal) c;
                System.out.println(cpe.exibeDados());
            } else if (c instanceof ContatoProfissional) {
                ContatoProfissional cpr = (ContatoProfissional) c;
                System.out.println(cpr.exibeDados());
            }
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public static void opcD(Agenda a) {
        System.out.println("Digite o email do contato");
        String email = sc.nextLine();

        Contato c = a.buscarContatoPorEmail(email);

        if (c != null) {
            if (c instanceof ContatoEmergencia) {
                ContatoEmergencia ce = (ContatoEmergencia) c;
                System.out.println(ce.exibeDados());
            } else if (c instanceof ContatoPessoal) {
                ContatoPessoal cpe = (ContatoPessoal) c;
                System.out.println(cpe.exibeDados());
            } else if (c instanceof ContatoProfissional) {
                ContatoProfissional cpr = (ContatoProfissional) c;
                System.out.println(cpr.exibeDados());
            }
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public static void opcE(Agenda a) {
        System.out.println("Digite o telefone do contato");
        String telefone = sc.nextLine();

        Contato c = a.buscarContatoPorTelefone(telefone);

        if (c != null) {
            if (c instanceof ContatoEmergencia) {
                ContatoEmergencia ce = (ContatoEmergencia) c;
                System.out.println(ce.exibeDados());
            } else if (c instanceof ContatoPessoal) {
                ContatoPessoal cpe = (ContatoPessoal) c;
                System.out.println(cpe.exibeDados());
            } else if (c instanceof ContatoProfissional) {
                ContatoProfissional cpr = (ContatoProfissional) c;
                System.out.println(cpr.exibeDados());
            }
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public static void opcF(Agenda a) {
        System.out.println("A agenda possui " + a.getQuantidadeContatos() + " contatos atualmente.");
    }
}