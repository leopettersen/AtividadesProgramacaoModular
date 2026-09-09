public class Item { // Declara a classe pública Item.
    private Produto produto; // Atributo que guarda o objeto da classe Produto. É uma composição.
    private int quantidade; // Atributo que guarda quantas unidades desse produto foram compradas.
    private double valorTotal; // Atributo que guarda o subtotal (preço do produto * quantidade).

    // Método construtor: exige um produto e uma quantidade no momento da criação do Item.
    public Item(Produto produto, int quantidade) {
        this.produto = produto; // Salva o objeto produto passado por parâmetro.
        this.quantidade = quantidade; // Salva a quantidade passada por parâmetro.
        this.valorTotal = quantidade * produto.getPreco(); // Calcula automaticamente o subtotal inicial.
    }

    // Retorna o objeto Produto associado a este item.
    public Produto getProduto() {
        return produto;
    }

    // Altera o produto deste item.
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // Retorna a quantidade comprada deste item.
    public int getQuantidade() {
        return quantidade;
    }

    // Altera a quantidade do item.
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Retorna o valor total (subtotal) deste item específico.
    public double getValorTotal() {
        return valorTotal;
    }

    // Método privado (só pode ser usado dentro desta classe) para alterar o valor total.
    private void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método que recalcula e atualiza o subtotal caso a quantidade ou preço mudem.
    public double calculaValorTotal() {
        setValorTotal(produto.getPreco() * quantidade); // Multiplica o preço pela nova quantidade.
        return getValorTotal(); // Retorna o valor atualizado.
    }
}