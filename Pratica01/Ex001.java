import java.util.Scanner;

public class Ex001 {
    static class Pessoa {
        private String nome;
        private String sobrenome;
        private int idade; // anos
        private double altura; // m
        private double peso; // Kg
        private double imc;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public double getImc() {
            return imc;
        }

        public void setImc(double imc) {
            this.imc = imc;
        }

        public double calculaIMC() {
            return this.peso / (this.altura * this.altura);
        }

        public String informaObesidade() {
            if (this.imc >= 40) {
                return "Obesidade grau 3";
            } else if (this.imc >= 35) {
                return "Obesidade grau 2";
            } else if (this.imc >= 30) {
                return "Obesidade grau 1";
            } else if (this.imc >= 25) {
                return "Sobrepeso";
            } else if (this.imc >= 18.5) {
                return "Peso normal";
            }
            return "Abaixo do peso";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        Pessoa p1 = new Pessoa();

        System.out.println("Digite seu nome: ");
        p1.setNome(sc.next());
        System.out.println("Digite seu sobrenome: ");
        p1.setSobrenome(sc.next());
        System.out.println("Digite sua idade: ");
        p1.setIdade(sc.nextInt());
        System.out.println("Digite sua altura em m: ");
        p1.setAltura(sc.nextDouble());
        System.out.println("Digite sua peso em Kg: ");
        p1.setPeso(sc.nextDouble());

        double imc = p1.calculaIMC();
        p1.setImc(imc);

        System.out.println("Nome: " + p1.getNome() + " " + p1.getSobrenome() + " - Valor do IMC: " + imc + " - Faixa de peso: " + p1.informaObesidade());
    }
}