import java.util.HashMap;

public class Estoque {
    private HashMap<String, Produto> produtos = new HashMap<>();

    public Estoque() {}

    public HashMap<String, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<String, Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean produtoExiste(String codigo) {
        return produtos.containsKey(codigo);
    }

    public boolean adicionarProduto(String codigo, Produto produto) {
        if (!produtoExiste(codigo)) {
            produtos.put(codigo, produto);
            return true;
        }
        return false;
    }

    public Produto buscarProduto(String codigo) {
        return produtos.get(codigo);
    }

    public boolean removerProduto(String codigo) {
        if (produtoExiste(codigo)) {
            produtos.remove(codigo);
            return true;
        }
        return false;
    }

    public int tamanho() {
        return produtos.size();
    }

    public void listarProdutos() {
        for (HashMap.Entry<String, Produto> entry : produtos.entrySet()) {
            System.out.println("Código: " + entry.getKey() +
                    " - Nome: " + entry.getValue().getNome() +
                    " - Preço: R$" + String.format("%.2f", entry.getValue().getPreco()) +
                    " - Estoque: " + entry.getValue().getQuantidade());
        }
    }

    public void listarEstoqueBaixo() {
        for (HashMap.Entry<String, Produto> entry : produtos.entrySet()) {
            if (entry.getValue().getQuantidade() < 5) {
                System.out.println("Código: " + entry.getKey() +
                        " - Nome: " + entry.getValue().getNome() +
                        " - Estoque: " + entry.getValue().getQuantidade());
            }
        }
    }
}