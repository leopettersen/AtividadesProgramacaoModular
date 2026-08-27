import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ex002 {
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

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
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

        public String exibirInformacoes() {
            return "\n--------------------\n" +
                    "RELATÓRIO DE " + this.nome + "\n" +
                    "Idade: " + this.idade + " anos\n" +
                    "Casa: " + this.casa +
                    "\n--------------------\n";
        }

        public String calcularCasa() {
            double grifinoria, sonserina, corvinal, lufaLufa;
            grifinoria = this.coragem * 2 + this.lealdade;
            sonserina = this.ambicao * 2 + this.estrategia;
            corvinal = this.inteligencia * 2 + this.criatividade;
            lufaLufa = (this.lealdade * 2 + this.coragem) / 3;

            double maior = Math.max(Math.max(grifinoria, sonserina), Math.max(corvinal, lufaLufa));

            if (maior == grifinoria) return "Grifinória";
            if (maior == sonserina) return "Sonserina";
            if (maior == corvinal) return "Corvinal";
            return "Lufa-Lufa";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);
        List<Aluno> alunos = new ArrayList<>();
        String nome;

        while (true) {
            System.out.println("Digite o nome do aluno (fim para sair): ");
            nome = sc.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                System.out.println("Você escolheu sair!");
                break;
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);

            System.out.println("Digite a idade do aluno: ");
            aluno.setIdade(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a coragem do aluno: ");
            aluno.setCoragem(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a inteligência do aluno: ");
            aluno.setInteligencia(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a ambição do aluno: ");
            aluno.setAmbicao(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a lealdade do aluno: ");
            aluno.setLealdade(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a estratégia do aluno: ");
            aluno.setEstrategia(sc.nextInt());
            sc.nextLine();

            System.out.println("Digite a criatividade do aluno: ");
            aluno.setCriatividade(sc.nextInt());
            sc.nextLine();

            aluno.setCasa(aluno.calcularCasa());
            alunos.add(aluno);

            System.out.println(aluno.exibirInformacoes());
        }
    }
}