import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.Normalizer;

public class Main {
        static List<Aluno> alunos = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);
        static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public static void main(String[] args) {
            sc.useLocale(java.util.Locale.US);
            int opcao;

            do {
                System.out.println("\n1 - Cadastrar aluno");
                System.out.println("2 - Listar todos os alunos");
                System.out.println("3 - Exibir alunos de uma casa");
                System.out.println("4 - Exibir alunos por casa");
                System.out.println("5 - Exibir alunos maiores de idade");
                System.out.println("6 - Exibir alunos menores de idade");
                System.out.println("7 - Buscar alunos por sobrenome");
                System.out.println("8 - Encerrar");
                System.out.print("Escolha uma opcao: ");
                opcao = lerInteiro();

                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        listarAlunos(alunos);
                        break;
                    case 3:
                        exibirAlunosDeCasa();
                        break;
                    case 4:
                        exibirAlunosPorCasa();
                        break;
                    case 5:
                        exibirMaioresDeIdade();
                        break;
                    case 6:
                        exibirMenoresDeIdade();
                        break;
                    case 7:
                        buscarPorSobrenome();
                        break;
                    case 8:
                        System.out.println("Encerrando o sistema.");
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } while (opcao != 8);
        }

        static int lerInteiro() {
            while (!sc.hasNextInt()) {
                System.out.print("Digite um numero valido: ");
                sc.next();
            }
            int valor = sc.nextInt();
            sc.nextLine();
            return valor;
        }

        static LocalDate lerDataNascimento() {
            LocalDate data = null;
            while (data == null) {
                System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                String entrada = sc.nextLine();
                try {
                    LocalDate dataConvertida = LocalDate.parse(entrada, formatoData);
                    if (dataConvertida.isAfter(LocalDate.now())) {
                        System.out.println("Data invalida: nao pode ser no futuro.");
                        continue;
                    }
                    data = dataConvertida;
                } catch (DateTimeParseException e) {
                    System.out.println("Data invalida. Use o formato dd/MM/yyyy.");
                }
            }
            return data;
        }

        static void cadastrarAluno() {
            if (alunos.size() >= 10) {
                System.out.println("Limite de 10 alunos atingido.");
                return;
            }

            System.out.println("Digite o nome do aluno (fim para sair): ");
            String nome = sc.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                System.out.println("Cadastro encerrado.");
                return;
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);

            aluno.setDataNascimento(lerDataNascimento());
            aluno.setIdade(aluno.calcularIdade());

            System.out.println("Digite a coragem do aluno: ");
            aluno.setCoragem(lerInteiro());

            System.out.println("Digite a inteligencia do aluno: ");
            aluno.setInteligencia(lerInteiro());

            System.out.println("Digite a ambicao do aluno: ");
            aluno.setAmbicao(lerInteiro());

            System.out.println("Digite a lealdade do aluno: ");
            aluno.setLealdade(lerInteiro());

            System.out.println("Digite a estrategia do aluno: ");
            aluno.setEstrategia(lerInteiro());

            System.out.println("Digite a criatividade do aluno: ");
            aluno.setCriatividade(lerInteiro());

            aluno.setCasa(aluno.calcularCasa());
            aluno.setCodigoMatricula(aluno.gerarCodigoMatricula(alunos.size() + 1));
            alunos.add(aluno);

            System.out.println(aluno.exibirInformacoes());
        }

        static void listarAlunos(List<Aluno> lista) {
            if (lista.isEmpty()) {
                System.out.println("Nenhum aluno cadastrado.");
                return;
            }
            for (Aluno aluno : lista) {
                System.out.println(aluno.exibirInformacoes());
            }
        }

        static void exibirAlunosDeCasa() {
            System.out.print("Digite o nome da casa: ");
            String casaInformada = sc.nextLine();
            List<Aluno> resultado = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if (aluno.verificarCasa(casaInformada)) {
                    resultado.add(aluno);
                }
            }
            listarAlunos(resultado);
            System.out.println("Total de alunos na casa: " + resultado.size());
        }

        static void exibirAlunosPorCasa() {
            String[] casas = {"Grifinoria", "Sonserina", "Corvinal", "Lufa-Lufa"};
            for (String casa : casas) {
                System.out.println("\n== " + casa.toUpperCase() + " ==");
                List<Aluno> resultado = new ArrayList<>();
                for (Aluno aluno : alunos) {
                    if (aluno.verificarCasa(casa)) {
                        resultado.add(aluno);
                    }
                }
                listarAlunos(resultado);
            }
        }

        static void exibirMaioresDeIdade() {
            List<Aluno> resultado = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if (aluno.verificarMaioridadeMagica()) {
                    resultado.add(aluno);
                }
            }
            listarAlunos(resultado);
        }

        static void exibirMenoresDeIdade() {
            List<Aluno> resultado = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if (!aluno.verificarMaioridadeMagica()) {
                    resultado.add(aluno);
                }
            }
            listarAlunos(resultado);
        }

        static void buscarPorSobrenome() {
            System.out.print("Digite o sobrenome (ou parte dele): ");
            String sobrenome = sc.nextLine();
            List<Aluno> resultado = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if (aluno.verificarPresencaPalavra(sobrenome)) {
                    resultado.add(aluno);
                }
            }
            listarAlunos(resultado);
        }
}
