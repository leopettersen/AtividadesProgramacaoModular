import java.util.*; // Importa todas as classes do pacote util (Scanner, List, ArrayList, InputMismatchException).

public class Pratica02 { // Declara a classe principal.
    // Método 'main', o ponto de partida onde a execução do programa em Java começa.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Cria o Scanner para ler dados digitados no teclado.

        List<Produto> produtos = new ArrayList<>(); // Cria o "banco de dados" em memória para os produtos da loja.
        // Adiciona 3 produtos predefinidos à lista disponível para compra.
        produtos.add(new Produto("Arroz", "001", 26.50));
        produtos.add(new Produto("Cerveja", "002", 6.13));
        produtos.add(new Produto("Picanha", "003", 99.98));

        Fatura fatura = new Fatura(); // Cria uma nova fatura zerada para o cliente.

        // Declara variáveis que serão usadas para controlar a navegação nos menus.
        int opcao = 0;
        String codigo;
        int quantidade;

        do { // Inicia um laço de repetição. O menu será mostrado até a opção for 5 (Finalizar).
            System.out.println("---OPÇÕES---");
            System.out.println("1 - COMPRAR");
            System.out.println("2 - VER FATURA");
            System.out.println("3 - EXCLUIR ITEM");
            System.out.println("4 - ALTERAR ITEM");
            System.out.println("5 - FINALIZAR");

            try { // Bloco para tentar ler a entrada do usuário e prevenir quebras se ele digitar letras em vez de números.
                opcao = sc.nextInt(); // Lê a opção (número inteiro).
            } catch (InputMismatchException e) { // Captura o erro caso o usuário digite texto (como "abc").
                System.out.println("Digite uma opção válida!"); // Avisa o usuário do erro.
                sc.nextLine(); // "Limpa" o Enter ou o lixo que ficou no leitor (Scanner).
                continue; // Pula o resto do código e volta para o início do 'do-while'.
            }
            sc.nextLine(); // Limpa o buffer do teclado (o 'Enter' que ficou após o nextInt).

            // Verifica se o número digitado está fora do intervalo de 1 a 5.
            if (opcao < 1 || opcao > 5) {
                System.out.println("Digite uma opção válida!");
                continue; // Volta para o início do menu.
            }

            // SEÇÃO 1: COMPRAR ITEM
            if (opcao == 1) {
                System.out.println("---PRODUTOS DISPONÍVEIS---");
                for (Produto produto : produtos) { // Imprime na tela todos os produtos disponíveis na loja.
                    System.out.println(produto.getNome() + " - " + produto.getCodigo());
                }
                System.out.println("Digite o código do produto que deseja comprar (0 para voltar): ");
                codigo = sc.nextLine(); // Lê o código digitado.

                if (codigo.equals("0")) { // Permite ao usuário desistir e voltar ao menu.
                    continue;
                }

                Produto produtoEscolhido = null; // Inicia a variável vazia para tentar achar o produto.
                for (Produto produto : produtos) { // Busca o produto pelo código na lista.
                    if (produto.getCodigo().equals(codigo)) { // Se encontrou o código...
                        produtoEscolhido = produto; // ...salva o produto encontrado.
                        break; // Para a busca, pois já achou.
                    }
                }

                if (produtoEscolhido == null) { // Se rodou todo o loop e continuou null, o código não existe.
                    System.out.println("Código inválido!");
                    continue; // Volta para o menu inicial.
                }

                System.out.println("Digite a quantidade que deseja comprar: ");
                try {
                    quantidade = sc.nextInt(); // Lê a quantidade.
                } catch (InputMismatchException e) { // Protege contra a digitação de texto no lugar de números.
                    System.out.println("Quantidade inválida!");
                    sc.nextLine(); // Limpa o Scanner.
                    continue;
                }
                sc.nextLine(); // Limpa o buffer.

                if (quantidade <= 0) { // Bloqueia a compra de quantidades zeradas ou negativas.
                    System.out.println("Quantidade deve ser maior que zero!");
                    continue;
                }

                // Cria um novo Item (produto + qtd) e adiciona diretamente na fatura.
                fatura.adicionarItem(new Item(produtoEscolhido, quantidade));
            }

            // SEÇÃO 2: VER FATURA
            else if (opcao == 2) {
                if (fatura.getItens().isEmpty()) { // Verifica se a lista de itens da fatura está vazia.
                    System.out.println("Nenhum item na fatura.");
                    continue;
                }
                System.out.println("---FATURA ATUAL---");
                for (Item item : fatura.getItens()) { // Lista todos os itens que o cliente já comprou.
                    // Imprime nome, quantidade e o valor formatado como moeda (R$0.00).
                    System.out.println("Nome: " + item.getProduto().getNome() + " - Quantidade: " + item.getQuantidade() + " - Total: " + String.format("R$%.2f", item.getValorTotal()));
                }
                // Imprime o valor total geral de tudo.
                System.out.println("Valor total da fatura: " + String.format("R$%.2f", fatura.getValorTotal()));
            }

            // SEÇÃO 3: EXCLUIR ITEM
            else if (opcao == 3) {
                System.out.println("---ITENS NA FATURA---");
                for (Item item : fatura.getItens()) { // Mostra o que já está na fatura para ajudar a escolher o que deletar.
                    System.out.println(item.getProduto().getNome() + " - " + item.getProduto().getCodigo());
                }
                System.out.println("Digite o código do produto que deseja remover (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) { // Opção de saída sem apagar nada.
                    continue;
                }

                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) { // Percorre a fatura tentando achar o item com aquele código.
                    if (item.getProduto().getCodigo().equals(codigo)) {
                        itemEscolhido = item; // Guarda a referência do item achado.
                        break;
                    }
                }

                if (itemEscolhido == null) { // Se não encontrou o código na fatura...
                    System.out.println("Código inválido!");
                    continue;
                }

                fatura.removerItem(itemEscolhido); // Manda a classe fatura remover o item (o que também já recalcula o total).
                System.out.println("Item removido com sucesso!");
            }

            // SEÇÃO 4: ALTERAR ITEM
            else if (opcao == 4) {
                System.out.println("---ITENS NA FATURA---");
                for (Item item : fatura.getItens()) { // Exibe os itens atuais da fatura.
                    System.out.println(item.getProduto().getNome() + " - " + item.getProduto().getCodigo());
                }
                System.out.println("Digite o código do produto que deseja alterar (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) { // Busca na fatura o item pelo código do produto que ele contém.
                    if (item.getProduto().getCodigo().equals(codigo)) {
                        itemEscolhido = item;
                        break;
                    }
                }

                if (itemEscolhido == null) {
                    System.out.println("Código inválido!");
                    continue;
                }

                System.out.println("Digite a quantidade nova: ");
                try {
                    quantidade = sc.nextInt(); // Lê a nova quantidade desejada.
                } catch (InputMismatchException e) { // Proteção contra digitação errada.
                    System.out.println("Quantidade inválida!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                if (quantidade <= 0) { // Impede colocar uma quantidade inválida.
                    System.out.println("Quantidade deve ser maior que zero!");
                    continue;
                }

                // Usa o método da Fatura para mudar a quantidade e recalcular todos os valores automaticamente.
                fatura.alterarQuantidadeItem(itemEscolhido, quantidade);
            }
        } while (opcao != 5); // Fim do bloco "do-while". Se a opção for 5, ele quebra o laço de repetição.

        System.out.println("VOCÊ ESCOLHEU SAIR!");
        // Exibe o total de toda a compra antes de finalizar a execução.
        System.out.println("Valor total da fatura: " + String.format("R$%.2f", fatura.getValorTotal()));

        sc.close(); // Fecha o Scanner, liberando o recurso de leitura do teclado no sistema operacional.
    }
}