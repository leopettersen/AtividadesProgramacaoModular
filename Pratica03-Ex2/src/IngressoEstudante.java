public class IngressoEstudante extends Ingresso {

    private String instituicaoEnsino;

    public IngressoEstudante(int codigo, String nomeEvento, String setor, double valorBase, String instituicaoEnsino) {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }
    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public double calcularValorFinal() {
        return getValorBase() * 0.5;
    }

    public String obterBeneficios() {
        return "Direito à meia-entrada (50% de desconto) - Instituição de ensino: " + instituicaoEnsino;
    }
}
