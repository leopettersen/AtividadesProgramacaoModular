import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bilheteria b = new Bilheteria();

        while (true) {
            char opc = menu();
            switch (opc) {
                case 'a': opcA(b); break;
                case 'b': opcB(b); break;
                case 'c': opcC(b); break;
                case 'd': opcD(b); break;
                case 'e': opcE(b); break;
                case 'f': opcF(b); break;
                case 'g': sc.close(); return;
                default: System.out.println("Opção inválida");
            }
        }
    }

    public static char menu() {
        System.out.println("");
        System.out.println("----MENU----");
        System.out.println("(a) - Cadastrar ingresso");
        System.out.println("(b) - Remover ingresso");
        System.out.println("(c) - Buscar ingresso por código");
        System.out.println("(d) - Listar todos os ingressos");
        System.out.println("(e) - Calcular arrecadação total");
        System.out.println("(f) - Listar benefícios dos ingressos");
        System.out.println("(g) - Finalizar");
        System.out.println("");

        char opc = sc.next().toLowerCase().charAt(0);
        sc.nextLine();

        return opc;
    }

    public static void opcA(Bilheteria b) {
        System.out.println("Qual o tipo do ingresso?");
        System.out.println("1 - Comum");
        System.out.println("2 - Estudante");
        System.out.println("3 - VIP");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Digite uma opção válida!");
            return;
        }

        System.out.println("Digite o código do ingresso: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if (b.buscarIngresso(codigo) != null) {
            System.out.println("Já existe um ingresso cadastrado com o código " + codigo + "!");
            return;
        }

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = sc.nextLine();

        System.out.println("Digite o setor: ");
        String setor = sc.nextLine();

        System.out.println("Digite o valor base (R$): ");
        double valorBase = sc.nextDouble();
        sc.nextLine();

        if (valorBase <= 0) {
            System.out.println("Valor base deve ser maior que zero!");
            return;
        }

        Ingresso ingresso;
        if (tipo == 1) {
            ingresso = new IngressoComum(codigo, nomeEvento, setor, valorBase);
        } else if (tipo == 2) {
            System.out.println("Digite a instituição de ensino: ");
            String instituicao = sc.nextLine();
            ingresso = new IngressoEstudante(codigo, nomeEvento, setor, valorBase, instituicao);
        } else {
            System.out.println("Possui acesso ao backstage? (s/n): ");
            boolean backstage = sc.next().toLowerCase().charAt(0) == 's';
            sc.nextLine();

            System.out.println("Digite o número da lounge: ");
            int lounge = sc.nextInt();
            sc.nextLine();

            ingresso = new IngressoVIP(codigo, nomeEvento, setor, valorBase, backstage, lounge);
        }

        if (b.adicionarIngresso(ingresso)) {
            System.out.println("Ingresso cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar o ingresso!");
        }
    }

    public static void opcB(Bilheteria b) {
        System.out.println("Digite o código do ingresso que você deseja remover: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if (b.removerIngresso(codigo)) {
            System.out.println("Exclusão bem sucedida!");
        } else {
            System.out.println("Ingresso com código " + codigo + " não encontrado!");
        }
    }

    public static void opcC(Bilheteria b) {
        System.out.println("Digite o código do ingresso: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Ingresso i = b.buscarIngresso(codigo);

        if (i != null) {
            System.out.println(i.exibirInformacoesBasicas());
            System.out.println("Tipo: " + i.getClass().getSimpleName());
            System.out.println("Valor final: R$ " + String.format("%.2f", i.calcularValorFinal()));
            System.out.println("Benefícios: " + i.obterBeneficios());
        } else {
            System.out.println("Ingresso com código " + codigo + " não encontrado!");
        }
    }

    public static void opcD(Bilheteria b) {
        b.listarIngressos();
    }

    public static void opcE(Bilheteria b) {
        System.out.println("Arrecadação total: R$ " + String.format("%.2f", b.calcularArrecadacaoTotal()));
    }

    public static void opcF(Bilheteria b) {
        b.listarBeneficios();
    }
}
