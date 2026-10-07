public abstract class Ingresso {

    private int codigo;
    private String nomeEvento;
    private String setor;
    private double valorBase;

    public Ingresso(int codigo, String nomeEvento, String setor, double valorBase) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.setor = setor;
        setValorBase(valorBase);
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        if (valorBase <= 0) {
            throw new IllegalArgumentException("Valor base deve ser maior que zero!");
        }
        this.valorBase = valorBase;
    }

    public String exibirInformacoesBasicas() {
        return "Código: " + codigo + " - Evento: " + nomeEvento + " - Setor: " + setor
                + " - Valor base: R$ " + String.format("%.2f", valorBase);
    }

    public abstract double calcularValorFinal();

    public abstract String obterBeneficios();
}
