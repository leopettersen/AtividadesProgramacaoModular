import java.util.Scanner;

public class Ex008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] precos = new double[10];
        int[] quantidades = new double[10];
        int indexMaisVendido = 0;
        int maiorQuantidade = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Produto " + (i + 1) + ": ");
            System.out.println("Digite o valor do produto: ");
            precos[i] = sc.nextDouble();
            System.out.println("Digite a quantidade vendida: ");
            quantidades[i] = sc.nextDouble();
            if (quantidades[i] > maiorQuantidade) {
                maiorQuantidade = quantidades[i];
                indexMaisVendido = i;
            }
        }

        double valorTotal = 0.0;
        System.out.println("Relátorio: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Produto " + (i + 1) + ": ");
            System.out.println("Quantidade vendida: " + quantidades[i]);
            System.out.println("Valor unitário: R$" + precos[i]);
            System.out.println("Valor das vendas: R$" + precos[i] * quantidades[i]);
            valorTotal += precos[i] * quantidades[i];
        }

        System.out.println("Valor total das vendas: R$" + valorTotal);
        System.out.println("Comissão total do vendedor: R$" + valorTotal * 0.05);
        System.out.println("Preço do objeto mais vendido: R$" + precos[indexMaisVendido] + " que está na posição " + indexMaisVendido);
    }
}