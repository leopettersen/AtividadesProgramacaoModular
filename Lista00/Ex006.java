import java.util.Scanner;

class Aluno {
    String numero;
    String[] respostas;
    int nota;

    public Aluno(String numero, String[] respostas) {
        this.numero = numero;
        this.respostas = respostas;
    }
}

public class Ex006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];
        String[] gabarito = new String[8];

        for (int i = 0; i < 8; i++) {
            System.out.println("Digite o gabarito da questão " + (i + 1) + ": ");
            gabarito[i] = sc.nextLine();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("ALUNO " + (i + 1));
            System.out.println("Digite o número do aluno: ");
            String numero = sc.nextLine();

            String[] respostasAluno = new String[8];
            for (int j = 0; j < 8; j++) {
                System.out.println("Digite a resposta do aluno na questão " + (j + 1) + ": ");
                respostasAluno[j] = sc.nextLine();
            }

            alunos[i] = new Aluno(numero, respostasAluno);
        }

        int aprovados = 0;
        for (Aluno a : alunos) {
            int nota = 0;
            for (int i = 0; i < 8; i++) {
                if (a.respostas[i].equals(gabarito[i])) {
                    nota++;
                }
            }
            a.nota = nota;
            if (nota >= 6) {
                aprovados++;
            }

            System.out.println("Número do aluno: " + a.numero + " | Nota: " + a.nota);
        }

        double porcentagemAprovacao = (aprovados / 10.0) * 100.0;
        System.out.println("Porcentagem aprovados: " + porcentagemAprovacao + "%");

        sc.close();
    }
}