public class IngressoComum extends Ingresso {

    public IngressoComum(int codigo, String nomeEvento, String setor, double valorBase) {
        super(codigo, nomeEvento, setor, valorBase);
    }

    public double calcularValorFinal() {
        return getValorBase();
    }

    public String obterBeneficios() {
        return "Sem benefícios adicionais.";
    }
}
