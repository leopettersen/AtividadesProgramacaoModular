import java.util.Scanner;

public class Ex009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[6];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite um numero inteiro: ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("RELATÓRIO");
        System.out.println("Os números pares são: ");
        int somaPares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0){
                System.out.println("número " + numeros[i] + " na posição " + (i + 1);
                somaPares += numeros[i];
            }
        }
        System.out.println("Soma dos pares = " + somaPares);

        System.out.println("Os números ímpares são: ");
        int quantidadeImpares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0){
                System.out.println("número " + numeros[i] + " na posição " + (i + 1);
                quantidadeImpares++;
            }
        }
        System.out.println("Quantidade de ímpares = " + quantidadeImpares);
        sc.close();
    }
}