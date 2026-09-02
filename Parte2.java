import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.Normalizer;

public class Parte2 {
    static class Aluno {
        String nome;
        int idade;
        int coragem;
        int inteligencia;
        int ambicao;
        int lealdade;
        int estrategia;
        int criatividade;
        String casa;
        LocalDate dataNascimento;
        String codigoMatricula;

        public Aluno() {
            this.nome = "";
            this.idade = 0;
            this.coragem = 0;
            this.inteligencia = 0;
            this.ambicao = 0;
            this.lealdade = 0;
            this.estrategia = 0;
            this.criatividade = 0;
            this.casa = "";
            this.dataNascimento = null;
            this.codigoMatricula = "";
        }

        public Aluno(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade, int estrategia, int criatividade) {
            this.nome = nome;
            this.idade = idade;
            this.coragem = coragem;
            this.inteligencia = inteligencia;
            this.ambicao = ambicao;
            this.lealdade = lealdade;
            this.estrategia = estrategia;
            this.criatividade = criatividade;
            this.casa = "";
            this.dataNascimento = null;
            this.codigoMatricula = "";
        }

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = capitalizarNome(nome);
        }

        public int getIdade() {
            return idade;
        }
        public void setIdade(int idade) {
            this.idade = idade;
        }

        public int getCoragem() {
            return coragem;
        }
        public void setCoragem(int coragem) {
            this.coragem = coragem;
        }

        public int getInteligencia() {
            return inteligencia;
        }
        public void setInteligencia(int inteligencia) {
            this.inteligencia = inteligencia;
        }

        public int getAmbicao() {
            return ambicao;
        }
        public void setAmbicao(int ambicao) {
            this.ambicao = ambicao;
        }

        public int getLealdade() {
            return lealdade;
        }
        public void setLealdade(int lealdade) {
            this.lealdade = lealdade;
        }

        public int getCriatividade() {
            return criatividade;
        }
        public void setCriatividade(int criatividade) {
            this.criatividade = criatividade;
        }

        public int getEstrategia() {
            return estrategia;
        }
        public void setEstrategia(int estrategia) {
            this.estrategia = estrategia;
        }

        public String getCasa() {
            return casa;
        }
        public void setCasa(String casa) {
            this.casa = casa;
        }

        public LocalDate getDataNascimento() {
            return dataNascimento;
        }
        public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getCodigoMatricula() {
            return codigoMatricula;
        }
        public void setCodigoMatricula(String codigoMatricula) {
            this.codigoMatricula = codigoMatricula;
        }

        public static String capitalizarNome(String nome) {
            String[] partes = nome.trim().toLowerCase().split("\\s+");
            StringBuilder resultado = new StringBuilder();
            for (String parte : partes) {
                resultado.append(Character.toUpperCase(parte.charAt(0)))
                        .append(parte.substring(1))
                        .append(" ");
            }
            return resultado.toString().trim();
        }

        public static String removerAcentos(String texto) {
            String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
            return normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        }

        public String getSobrenome() {
            String[] partes = this.nome.trim().split("\\s+");
            if (partes.length == 1) {
                return "";
            }
            StringBuilder sobrenome = new StringBuilder();
            for (int i = 1; i < partes.length; i++) {
                sobrenome.append(partes[i]);
                if (i != partes.length - 1) {
                    sobrenome.append(" ");
                }
            }
            return sobrenome.toString();
        }

        public int calcularIdade() {
            if (this.dataNascimento == null) {
                return 0;
            }
            return Period.between(this.dataNascimento, LocalDate.now()).getYears();
        }

        public boolean verificarMaioridadeMagica() {
            return calcularIdade() >= 17;
        }

        public String formatarCasa() {
            return this.casa.toUpperCase();
        }

        public String gerarNomeUsuario() {
            String[] partes = this.nome.trim().split("\\s+");
            String primeiraLetra = String.valueOf(Character.toLowerCase(partes[0].charAt(0)));
            String sobrenome = getSobrenome().replaceAll("\\s+", "").toLowerCase();
            return primeiraLetra + sobrenome;
        }

        public String gerarCodigoMatricula(int posicao) {
            String[] partes = this.nome.trim().split("\\s+");
            String iniciais = String.valueOf(Character.toUpperCase(partes[0].charAt(0)));
            if (partes.length > 1) {
                String ultimoNome = partes[partes.length - 1];
                iniciais += Character.toUpperCase(ultimoNome.charAt(0));
            }
            int ano = LocalDate.now().getYear();
            return String.format("%s-%d-%02d", iniciais, ano, posicao);
        }

        public boolean verificarCasa(String casaInformada) {
            return removerAcentos(this.casa.trim().toLowerCase())
                    .equals(removerAcentos(casaInformada.trim().toLowerCase()));
        }

        public boolean verificarPresencaPalavra(String palavra) {
            return removerAcentos(getSobrenome().toLowerCase())
                    .contains(removerAcentos(palavra.trim().toLowerCase()));
        }

        public String exibirInformacoes() {
            return "\nNome: " + this.nome +
                    "\nIdade: " + this.idade + " anos" +
                    "\nCasa: " + formatarCasa() +
                    "\nMatricula: " + this.codigoMatricula +
                    "\nUsuario: " + gerarNomeUsuario() +
                    "\nMaior de idade magica: " + (verificarMaioridadeMagica() ? "Sim" : "Nao") + "\n";
        }

        public String calcularCasa() {
            double grifinoria, sonserina, corvinal, lufaLufa;
            grifinoria = this.coragem * 2 + this.lealdade;
            sonserina = this.ambicao * 2 + this.estrategia;
            corvinal = this.inteligencia * 2 + this.criatividade;
            lufaLufa = (this.lealdade * 2 + this.coragem) / 3;

            double maior = Math.max(Math.max(grifinoria, sonserina), Math.max(corvinal, lufaLufa));

            if (maior == grifinoria) return "Grifinoria";
            if (maior == sonserina) return "Sonserina";
            if (maior == corvinal) return "Corvinal";
            return "Lufa-Lufa";
        }
    }

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