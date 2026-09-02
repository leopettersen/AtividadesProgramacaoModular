import java.util.Scanner;
import java.util.Arrays;

public class Ex002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite um número inteiro: ");
            num[i] = sc.nextInt();
        }

        int maior = Arrays.stream(num).max().getAsInt();
        int menor = Arrays.stream(num).min().getAsInt();
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        if (num[0] >= num[1] && num[0] <= num[2]) {
            System.out.println(num[0] + " está dentro do intervalo [" + num[1] + ", " + num[2] + "]");
        } else {
            System.out.println(num[0] + " está fora do intervalo [" + num[1] + ", " + num[2] + "]");
        }

        if (num[0] % num[1] == 0) {
            System.out.println(num[0] + " é divisivel por " + num[1]);
        }

        if (num[0] % num[2] == 0) {
            System.out.println(num[0] + " é divisivel por " + num[2]);
        }

        sc.close();
    }
}