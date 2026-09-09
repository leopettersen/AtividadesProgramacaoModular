public class Main {
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
