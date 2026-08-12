import java.util.Scanner;

public class Ex003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de alunos matriculados: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] pm = new String[n];
        String[] c1 = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite a matricula do aluno " + (i + 1) + " de Programação Modular: ");
            pm[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Digite a matricula do aluno " + (i + 1) + " de Cálculo 1: ");
            c1[i] = sc.nextLine();
        }

        String[] intersecao = new String[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pm[i].equals(c1[j])) {
                    intersecao[k] = pm[i];
                    k++;
                    break;
                }
            }
        }

        System.out.println("Lista de alunos matriculados em ambas disciplinas: ");
        for (int i = 0; i < k; i++) {
            System.out.print(intersecao[i] + " ");
        }
        sc.close();
    }
}