import java.util.Scanner;
import java.util.Arrays;

public class Ex004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite quantos elementos o vetor x possui: ");
        int n = sc.nextInt();

        System.out.print("Digite quantos elementos o vetor y possui: ");
        int m = sc.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + " do vetor x: ");
            x[i] = sc.nextInt();
        }

        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("Digite o número " + (i + 1) + " do vetor y: ");
            y[i] = sc.nextInt();
        }

        int[] z = new int[n + m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int valor = x[i];
            boolean jaExiste = Arrays.stream(z, 0, k).anyMatch(elem -> elem == valor);
            if (!jaExiste) {
                z[k] = valor;
                k++;
            }
        }

        for (int i = 0; i < m; i++) {
            int valor = y[i];
            boolean jaExiste = Arrays.stream(z, 0, k).anyMatch(elem -> elem == valor);
            if (!jaExiste) {
                z[k] = valor;
                k++;
            }
        }

        System.out.println("Vetor z: ");
        for (int i = 0; i < k; i++) {
            System.out.print(z[i] + " ");
        }

        sc.close();
    }
}