import java.util.Scanner;

public class Ex010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] vendas = new double[12][4];
        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        for (int i = 0; i < vendas.length; i++) {
            for (int j = 0; j < vendas[i].length; j++) {
                System.out.println("Digite o valor de vendas da semana " + (j + 1) + " do mês de " + meses[i]);
                vendas[i][j] = sc.nextDouble();
            }
        }

        double semanas1 = 0.0;
        double semanas2 = 0.0;
        double semanas3 = 0.0;
        double semanas4 = 0.0;
        double totalAno = 0.0;
        for (int  i = 0; i < vendas.length; i++) {
            double soma = 0.0;
            for (int j = 0; j < vendas[i].length; j++) {
                soma += vendas[i][j];
                if (j == 0) {
                    semanas1 += vendas[i][j];
                }
                else if (j == 1) {
                    semanas2 += vendas[i][j];
                }
                else if (j == 2) {
                    semanas3 += vendas[i][j];
                }
                else if (j == 3) {
                    semanas4 += vendas[i][j];
                }
            }
            totalAno += soma;
            System.out.println("Total de vendas do mês de " + meses[i] + ": R$ " + soma);
        }
        System.out.println("Vendas da semana 1 no ano: R$ " + semanas1);
        System.out.println("Vendas da semana 2 no ano: R$ " + semanas2);
        System.out.println("Vendas da semana 3 no ano: R$ " + semanas3);
        System.out.println("Vendas da semana 4 no ano: R$ " + semanas4);
        System.out.println("Vendas totais do ano: R$ " +  totalAno);

        sc.close();
    }
}