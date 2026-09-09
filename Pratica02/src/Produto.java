public class Produto { // Declara a classe pública Produto, que pode ser acessada por outras classes.
    private String nome; // Atributo privado que guarda o nome do produto (ex: "Arroz").
    private String codigo; // Atributo privado que guarda o código identificador (ex: "001").
    private double preco; // Atributo privado que guarda o valor financeiro do produto.

    // Método construtor: executado sempre que você usa "new Produto(...)".
    public Produto(String nome, String codigo, double preco) {
        this.nome = nome; // O 'this' diferencia o atributo da classe do parâmetro recebido.
        this.codigo = codigo; // Salva o código recebido no parâmetro para o objeto atual.
        this.preco = preco; // Salva o preço recebido no parâmetro para o objeto atual.
    }

    // Método "getter" para ler o valor do atributo 'nome', que é privado.
    public String getNome() {
        return nome; // Retorna o nome atual do produto.
    }

    // Método "setter" para alterar o valor do atributo 'nome'.
    public void setNome(String nome) {
        this.nome = nome; // Atualiza o nome do produto com o novo valor passado.
    }

    // Método para ler o código do produto.
    public String getCodigo() {
        return codigo; // Retorna o código atual.
    }

    // Método para alterar o código do produto.
    public void setCodigo(String codigo) {
        this.codigo = codigo; // Atualiza o código.
    }

    // Método para ler o preço do produto.
    public double getPreco() {
        return preco; // Retorna o valor do preço.
    }

    // Método para alterar o preço do produto.
    public void setPreco(double preco) {
        this.preco = preco; // Atualiza o preço com um novo valor.
    }
}