import java.util.*;

public class Pratica02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", "001", 26.50));
        produtos.add(new Produto("Cerveja", "002", 6.13));
        produtos.add(new Produto("Picanha", "003", 99.98));

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
            System.out.println("5 - FINALIZAR");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida!");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            if (opcao < 1 || opcao > 5) {
                System.out.println("Digite uma opção válida!");
                continue;
            }

            if (opcao == 1) {
                System.out.println("---PRODUTOS DISPONÍVEIS---");
                for (Produto produto : produtos) {
                    System.out.println(produto.getNome() + " - " + produto.getCodigo());
                }
                System.out.println("Digite o código do produto que deseja comprar (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                Produto produtoEscolhido = null;
                for (Produto produto : produtos) {
                    if (produto.getCodigo().equals(codigo)) {
                        produtoEscolhido = produto;
                        break;
                    }
                }

                if (produtoEscolhido == null) {
                    System.out.println("Código inválido!");
                    continue;
                }

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
                    System.out.println(item.getProduto().getNome() + " - " + item.getProduto().getCodigo());
                }
                System.out.println("Digite o código do produto que deseja remover (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) {
                    if (item.getProduto().getCodigo().equals(codigo)) {
                        itemEscolhido = item;
                        break;
                    }
                }

                if (itemEscolhido == null) {
                    System.out.println("Código inválido!");
                    continue;
                }

                fatura.removerItem(itemEscolhido);
                System.out.println("Item removido com sucesso!");
            }

            else if (opcao == 4) {
                System.out.println("---ITENS NA FATURA---");
                for (Item item : fatura.getItens()) {
                    System.out.println(item.getProduto().getNome() + " - " + item.getProduto().getCodigo());
                }
                System.out.println("Digite o código do produto que deseja alterar (0 para voltar): ");
                codigo = sc.nextLine();

                if (codigo.equals("0")) {
                    continue;
                }

                Item itemEscolhido = null;
                for (Item item : fatura.getItens()) {
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

                fatura.alterarQuantidadeItem(itemEscolhido, quantidade);
            }
        } while (opcao != 5);

        System.out.println("VOCÊ ESCOLHEU SAIR!");
        System.out.println("Valor total da fatura: " + String.format("R$%.2f", fatura.getValorTotal()));

        sc.close();
    }
}