import java.util.Scanner;

public class ex001 {
    public static int fatorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int n = sc.nextInt();

        System.out.println(n + "!" + " = " + fatorial(n));

        sc.close();
    }
}