import java.util.Scanner;

public class Ex007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        double[] temperaturas = new double[12];
        int indexMaior = 0;
        int indexMenor = 0;

        System.out.println("Digite a temperatura média de cada mês:");

        for (int i = 0; i < 12; i++) {
            System.out.print((i + 1) + " - " + meses[i] + ": ");
            temperaturas[i] = sc.nextDouble();

            if (temperaturas[i] > temperaturas[indexMaior]) {
                indexMaior = i;
            }
            if (temperaturas[i] < temperaturas[indexMenor]) {
                indexMenor = i;
            }
        }

        System.out.println("Maior temperatura média: " + temperaturas[indexMaior] + "°C que ocorreu no mês de " + meses[indexMaior]);

        System.out.println("Menor temperatura média: " + temperaturas[indexMenor] + "°C que ocorreu no mês de " + meses[indexMenor]);

        sc.close();
    }
}