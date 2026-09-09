import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private List<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    private void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calculaValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getValorTotal();
        }
        setValorTotal(total);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        calculaValorTotal();
    }

    public void removerItem(Item item) {
        itens.remove(item);
        calculaValorTotal();
    }

    public void alterarQuantidadeItem(Item item, int novaQuantidade) {
        item.setQuantidade(novaQuantidade);
        item.calculaValorTotal();
        calculaValorTotal();
    }
}