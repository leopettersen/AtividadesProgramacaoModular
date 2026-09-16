import java.util.*;

public class Pratica02_Parte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();
        estoque.adicionarProduto("001", new Produto("Arroz", 26.50, 5));
        estoque.adicionarProduto("002", new Produto("Cerveja", 6.13, 3));
        estoque.adicionarProduto("003", new Produto("Picanha", 99.98, 4));

        Fatura fatura = new Fatura();

        int opcao = 0;
        String codigo;
        int quantidade;

        do {
            System.out.println("---OPÇÕES---");
            System.out.println("1 - COMPRAR");
            System.out.println("2 - VER FATURA");
            System.out.println("3 - EXCLUIR ITEM");
            System.out.println("4 - ALTERAR ITEM");
            System.out.println("5 - CONSULTAR PRODUTO");
            System.out.println("6 - ADICIONAR PRODUTO AO ESTOQUE");
            System.out.println("7 - REMOVER PRODUTO DO ESTOQUE");
            System.out.println("8 - REPOR ESTOQUE");
            System.out.println("9 - PRODUTOS COM ESTOQUE BAIXO");
            System.out.println("10 - FINALIZAR");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida!");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            if (opcao < 1 || opcao > 10) {
                System.out.println("Digite uma opção válida!");
                continue;
            }

            if (opcao == 1) {
                System.out.println("---PRODUTOS DISPONÍVEIS---");
                estoque.listarProdutos();
                System.out.println("Digite o código do produto que deseja comprar (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                if (!estoque.produtoExiste(codigo)) {
                    System.out.println("Código inválido!");
                    continue;
                }

                Produto produtoEscolhido = estoque.buscarProduto(codigo);

                System.out.println("Digite a quantidade que deseja comprar: ");
                try {
                    quantidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Quantidade inválida!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                if (quantidade <= 0) {
                    System.out.println("Quantidade deve ser maior que zero!");
                    continue;
                }

                if (!produtoEscolhido.retirarEstoque(quantidade)) {
                    System.out.println("Estoque insuficiente!");
                    continue;
                }

                fatura.adicionarItem(new Item(produtoEscolhido, quantidade));
            }

            else if (opcao == 2) {
                if (fatura.getItens().isEmpty()) {
                    System.out.println("Nenhum item na fatura.");
                    continue;
                }
                System.out.println("---FATURA ATUAL---");
                for (Item item : fatura.getItens()) {
                    System.out.println("Nome: " + item.getProduto().getNome() + " - Quantidade: " + item.getQuantidade() + " - Total: " + String.format("R$%.2f", item.getValorTotal()));
                }
                System.out.println("Valor total da fatura: " + String.format("R$%.2f", fatura.getValorTotal()));
            }

            else if (opcao == 3) {
                System.out.println("---ITENS NA FATURA---");
                for (Item item : fatura.getItens()) {
                    System.out.println(item.getProduto().getNome());
                }
                System.out.println("Digite o código do produto que deseja remover (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) {
                    if (estoque.produtoExiste(codigo) && item.getProduto() == estoque.buscarProduto(codigo)) {
                        itemEscolhido = item;
                        break;
                    }
                }

                if (itemEscolhido == null) {
                    System.out.println("Código inválido!");
                    continue;
                }

                itemEscolhido.getProduto().adicionarEstoque(itemEscolhido.getQuantidade());
                fatura.removerItem(itemEscolhido);
                System.out.println("Item removido com sucesso!");
            }

            else if (opcao == 4) {
                System.out.println("---ITENS NA FATURA---");
                for (Item item : fatura.getItens()) {
                    System.out.println(item.getProduto().getNome());
                }
                System.out.println("Digite o código do produto que deseja alterar (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                if (!estoque.produtoExiste(codigo)) {
                    System.out.println("Código inválido!");
                    continue;
                }

                Produto produtoBuscado = estoque.buscarProduto(codigo);
                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) {
                    if (item.getProduto() == produtoBuscado) {
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
                    quantidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Quantidade inválida!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                if (quantidade <= 0) {
                    System.out.println("Quantidade deve ser maior que zero!");
                    continue;
                }

                int diferenca = quantidade - itemEscolhido.getQuantidade();
                if (diferenca > 0 && !produtoBuscado.retirarEstoque(diferenca)) {
                    System.out.println("Estoque insuficiente!");
                    continue;
                } else if (diferenca < 0) {
                    produtoBuscado.adicionarEstoque(-diferenca);
                }

                fatura.alterarQuantidadeItem(itemEscolhido, quantidade);
            }

            else if (opcao == 5) {
                System.out.println("Digite o código do produto: ");
                codigo = sc.nextLine();

                if (!estoque.produtoExiste(codigo)) {
                    System.out.println("Código inválido!");
                    continue;
                }

                Produto produto = estoque.buscarProduto(codigo);
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + String.format("R$%.2f", produto.getPreco()));
                System.out.println("Estoque: " + produto.getQuantidade());
            }

            else if (opcao == 6) {
                System.out.println("Digite o código do novo produto: ");
                codigo = sc.nextLine();

                if (estoque.produtoExiste(codigo)) {
                    System.out.println("Já existe um produto com esse código!");
                    continue;
                }

                System.out.println("Digite o nome do produto: ");
                String nome = sc.nextLine();

                System.out.println("Digite o preço do produto: ");
                double preco;
                try {
                    preco = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Preço inválido!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                System.out.println("Digite a quantidade inicial em estoque: ");
                try {
                    quantidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Quantidade inválida!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                estoque.adicionarProduto(codigo, new Produto(nome, preco, quantidade));
                System.out.println("Produto adicionado com sucesso!");
            }

            else if (opcao == 7) {
                System.out.println("Digite o código do produto que deseja remover: ");
                codigo = sc.nextLine();

                if (!estoque.removerProduto(codigo)) {
                    System.out.println("Código inválido!");
                    continue;
                }

                System.out.println("Produto removido com sucesso!");
            }

            else if (opcao == 8) {
                System.out.println("Digite o código do produto: ");
                codigo = sc.nextLine();

                if (!estoque.produtoExiste(codigo)) {
                    System.out.println("Código inválido!");
                    continue;
                }

                System.out.println("Digite a quantidade a adicionar: ");
                try {
                    quantidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Quantidade inválida!");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                if (quantidade <= 0) {
                    System.out.println("Quantidade deve ser maior que zero!");
                    continue;
                }

                estoque.buscarProduto(codigo).adicionarEstoque(quantidade);
                System.out.println("Estoque reposto com sucesso!");
            }

            else if (opcao == 9) {
                System.out.println("---PRODUTOS COM ESTOQUE BAIXO---");
                estoque.listarEstoqueBaixo();
            }

        } while (opcao != 10);

        System.out.println("VOCÊ ESCOLHEU SAIR!");
        System.out.println("Valor total da fatura: " + String.format("R$%.2f", fatura.getValorTotal()));

        sc.close();
    }
}