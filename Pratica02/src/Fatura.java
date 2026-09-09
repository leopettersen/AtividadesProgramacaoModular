import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List.

public class Fatura { // Declara a classe pública Fatura.
    private List<Item> itens; // Declara uma lista que só aceita objetos do tipo 'Item'.
    private double valorTotal; // Atributo que guarda a soma de todos os itens da fatura.

    // Método construtor da Fatura. Não recebe parâmetros.
    public Fatura() {
        this.itens = new ArrayList<>(); // Inicializa a lista de itens vazia. Importante para evitar erro de NullPointer.
        this.valorTotal = 0.0; // Inicia a fatura zerada.
    }

    // Retorna a lista completa de itens.
    public List<Item> getItens() {
        return itens;
    }

    // Substitui a lista de itens atual por uma nova lista passada por parâmetro.
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    // Retorna o valor total da fatura (soma de todos os itens).
    public double getValorTotal() {
        return valorTotal;
    }

    // Método privado para atualizar o valor total da fatura internamente.
    private void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método para recalcular o valor total da fatura varrendo todos os itens.
    public void calculaValorTotal() {
        double total = 0.0; // Cria uma variável temporária começando em zero.
        for (Item item : itens) { // Laço de repetição (for-each): para cada 'item' dentro da lista 'itens'...
            total += item.getValorTotal(); // ...soma o subtotal do item ao 'total'.
        }
        setValorTotal(total); // Atualiza o atributo da classe com o somatório final.
    }

    // Método para adicionar um novo item à fatura.
    public void adicionarItem(Item item) {
        itens.add(item); // Adiciona o objeto 'item' à lista do ArrayList.
        calculaValorTotal(); // Recalcula o total geral da fatura para incluir o novo item.
    }

    // Método para remover um item da fatura.
    public void removerItem(Item item) {
        itens.remove(item); // Remove o objeto especificado da lista.
        calculaValorTotal(); // Recalcula o total geral subtraindo o item removido.
    }

    // Método para alterar a quantidade de um item que já está na lista.
    public void alterarQuantidadeItem(Item item, int novaQuantidade) {
        item.setQuantidade(novaQuantidade); // Atualiza a quantidade diretamente no objeto Item.
        item.calculaValorTotal(); // Pede ao objeto Item para recalcular seu próprio subtotal.
        calculaValorTotal(); // Recalcula o total geral da fatura.
    }
}