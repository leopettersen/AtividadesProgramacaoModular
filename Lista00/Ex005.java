import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Habitante {
    String sexo;
    String corOlhos;
    String corCabelos;
    int idade;

    public Habitante(String sexo, String corOlhos, String corCabelos, int idade) {
        this.sexo = sexo;
        this.corOlhos = corOlhos;
        this.corCabelos = corCabelos;
        this.idade = idade;
    }
}

public class Ex005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Habitante> habitantes = new ArrayList<>();
        int i = 1;

        while (true) {
            System.out.println("HABITANTE " + i);
            System.out.print("Digite a idade (-1 para encerrar): ");
            int idade = sc.nextInt();
            sc.nextLine();

            if (idade == -1) {
                break;
            }

            System.out.print("Digite o sexo (masculino/feminino): ");
            String sexo = sc.nextLine();

            System.out.print("Digite a cor dos olhos (azuis/verdes/castanhos): ");
            String corOlhos = sc.nextLine();

            System.out.print("Digite a cor dos cabelos (louros/castanhos/pretos): ");
            String corCabelos = sc.nextLine();

            habitantes.add(new Habitante(sexo, corOlhos, corCabelos, idade));
            i++;
        }

        if (habitantes.isEmpty()) {
            System.out.println("Nenhum habitante foi cadastrado.");
        } else {
            int maior = 0;
            int menor = 200;
            int ind = 0; // quantidade de mulheres que atendem os requisitos do enunciado

            for (Habitante h : habitantes) {
                if (h.idade > maior) {
                    maior = h.idade;
                }
                if (h.idade < menor) {
                    menor = h.idade;
                }

                boolean ehFeminino = h.sexo.equalsIgnoreCase("feminino");
                boolean idadeValida = h.idade >= 18 && h.idade <= 35;
                boolean olhosVerdes = h.corOlhos.equalsIgnoreCase("verdes");
                boolean cabelosLouros = h.corCabelos.equalsIgnoreCase("louros");

                if (ehFeminino && idadeValida && olhosVerdes && cabelosLouros) {
                    ind++;
                }
            }

            System.out.println("Maior idade: " + maior);
            System.out.println("Menor idade: " + menor);
            System.out.println("Mulheres (18-35 anos, olhos verdes, cabelos louros): " + ind);
        }

        sc.close();
    }
}