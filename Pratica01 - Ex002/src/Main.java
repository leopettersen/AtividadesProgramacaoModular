public class Main {
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