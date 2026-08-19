import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] resultados = new int[16][2];
        char[] times = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'};

        int[][] origem = new int[16][2];
        origem[9]  = new int[]{1, 2};
        origem[10] = new int[]{3, 4};
        origem[11] = new int[]{5, 6};
        origem[12] = new int[]{7, 8};
        origem[13] = new int[]{9, 10};
        origem[14] = new int[]{11, 12};
        origem[15] = new int[]{13, 14};

        for (int i = 1; i <= 15; i++) {
            System.out.println("Digite o resultado do jogo " + i + ": ");
            resultados[i][0] = sc.nextInt();
            resultados[i][1] = sc.nextInt();
        }

        int jogo = 15;
        while (jogo > 8) {
            boolean venceEsquerda = resultados[jogo][0] > resultados[jogo][1];
            if  (venceEsquerda) {
                jogo = origem[jogo][0];
            } else {
                jogo = origem[jogo][1];
            }
        }

        int indiceTime;
        boolean venceEsquerda = resultados[jogo][0] > resultados[jogo][1];
        if (venceEsquerda) {
            indiceTime = 2 * (jogo - 1);
        } else {
            ""indiceTime = 2 * (jogo - 1) + 1;
        }

        System.out.println("O time vencedor é: " + times[indiceTime]);
    }
}