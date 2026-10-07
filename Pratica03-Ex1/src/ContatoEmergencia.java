public class ContatoEmergencia extends Contato {

    private PrioridadeEmergencia prioridade; 
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone, PrioridadeEmergencia prioridade, String observacao) {
        super(nome, email, telefone);
        setPrioridade(prioridade);
        this.observacao = observacao;
    }

    public PrioridadeEmergencia getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEmergencia prioridade) {
        this.prioridade = prioridade;
    }

    public int getGrauPrioridade() {
        return prioridade.getValor();
    }

    public void setGrauPrioridade(int grauPrioridade) {
        if (grauPrioridade < 1 || grauPrioridade > 5) {
            throw new IllegalArgumentException("Grau de prioridade deve estar entre 1 e 5!");
        }
        this.prioridade = PrioridadeEmergencia.values()[grauPrioridade - 1];
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String exibeDados() {
        return "Contato: " + getNome() + " - Email: " + getEmail() + " - Telefone: " + getTelefone() + " - Prioridade: " + getGrauPrioridade() + " - Observação: " + observacao;
    }
}