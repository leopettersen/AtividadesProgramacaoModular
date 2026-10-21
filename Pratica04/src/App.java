import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import classes.Pedido;
import classes.PedidoAlimento;
import classes.PedidoEletronico;
import classes.PedidoRoupa;
import enums.Categoria;
import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;
import interfaces.Entregavel;

public class App {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();

        int opc;

        do {
            opc = menu();

            switch (opc) {
                case 1: {
                    Pedido novoPedido = opc1();

                    if (novoPedido != null) {
                        pedidos.add(novoPedido);
                        System.out.println("Pedido cadastrado com sucesso!");
                    }
                    break;
                }

                case 2:
                    opc2(pedidos);
                    break;

                case 3:
                    opc3(pedidos);
                    break;

                case 4:
                    opc4(pedidos);
                    break;

                case 5:
                    opc5(pedidos);
                    break;

                case 6:
                    opc6(pedidos);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opc != 0);

        sc.close();
    }

    public static int menu() {
        System.out.println();
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Cadastrar Pedido");
        System.out.println("2 - Alterar o Status de Pedido");
        System.out.println("3 - Processar Pedido");
        System.out.println("4 - Remover Cancelados");
        System.out.println("5 - Exibir Pedidos");
        System.out.println("6 - Exibir Pedidos Entregáveis");
        System.out.println("0 - Encerrar");
        System.out.println();

        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public static Pedido opc1() {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Digite o valor do pedido: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Categoria[] categorias = Categoria.values();

        System.out.println("Selecione a categoria:");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + " - " + categorias[i]);
        }

        System.out.print("Opção: ");
        int opcaoCategoria = sc.nextInt();
        sc.nextLine();

        if (opcaoCategoria < 1 || opcaoCategoria > categorias.length) {
            System.out.println("Categoria inválida!");
            return null;
        }

        Categoria categoriaEscolhida = categorias[opcaoCategoria - 1];

        try {
            Pedido novoPedido;

            switch (categoriaEscolhida) {
                case ELETRONICO:
                    novoPedido = new PedidoEletronico(
                        id, nomeCliente, valor, StatusPedido.PENDENTE
                    );
                    break;

                case ROUPA:
                    novoPedido = new PedidoRoupa(
                        id, nomeCliente, valor, StatusPedido.PENDENTE
                    );
                    break;

                case ALIMENTO:
                    novoPedido = new PedidoAlimento(
                        id, nomeCliente, valor, StatusPedido.PENDENTE
                    );
                    break;

                default:
                    System.out.println("Categoria inválida!");
                    return null;
            }

            return novoPedido;

        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
            return null;
        }
    }

    public static void opc2(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        System.out.print("Digite o ID do pedido que deseja alterar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedidoEncontrado = null;

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        StatusPedido[] statusDisponiveis = StatusPedido.values();

        System.out.println("Selecione o novo status:");

        for (int i = 0; i < statusDisponiveis.length; i++) {
            System.out.println((i + 1) + " - " + statusDisponiveis[i]);
        }

        System.out.print("Opção: ");
        int opcaoStatus = sc.nextInt();
        sc.nextLine();

        if (opcaoStatus < 1 || opcaoStatus > statusDisponiveis.length) {
            System.out.println("Opção inválida!");
            return;
        }

        StatusPedido novoStatus = statusDisponiveis[opcaoStatus - 1];

        try {
            pedidoEncontrado.setStatus(novoStatus);
            System.out.println("Status alterado com sucesso!");
        } catch (PedidoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void opc3(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        Iterator<Pedido> it = pedidos.iterator();

        while (it.hasNext()) {
            Pedido pedido = it.next();

            try {
                pedido.processarPedido();

                System.out.println(
                    "Pedido " + pedido.getId()
                    + " processado. Status atual: "
                    + pedido.getStatus()
                );

            } catch (PedidoInvalidoException e) {
                System.out.println(
                    "Pedido " + pedido.getId()
                    + ": " + e.getMessage()
                );
            }
        }
    }

    public static void opc4(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        Iterator<Pedido> it = pedidos.iterator();
        int removidos = 0;

        while (it.hasNext()) {
            Pedido pedido = it.next();

            if (pedido.getStatus() == StatusPedido.CANCELADO) {
                it.remove();
                removidos++;
            }
        }

        System.out.println(
            removidos + " pedido(s) cancelado(s) removido(s)."
        );
    }

    public static void opc5(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        boolean encontrou = false;

        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() != StatusPedido.CANCELADO) {
                exibirPedido(pedido);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há pedidos não cancelados para exibir.");
        }
    }

    public static void opc6(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        boolean encontrou = false;

        for (Pedido pedido : pedidos) {
            if (pedido instanceof Entregavel) {
                exibirPedido(pedido);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há pedidos entregáveis cadastrados.");
        }
    }

    private static void exibirPedido(Pedido pedido) {
        System.out.println("--------------------------------");

        System.out.println("ID: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Categoria: " + pedido.getCategoria());
        System.out.println("Status: " + pedido.getStatus());

        System.out.printf(
            "Valor original: R$ %.2f%n",
            pedido.getValor()
        );

        System.out.printf(
            "Valor final: R$ %.2f%n",
            pedido.calcularValorFinal()
        );

        System.out.printf(
            "Frete: R$ %.2f%n",
            pedido.calcularFrete()
        );

        System.out.printf(
            "Total com frete: R$ %.2f%n",
            pedido.calcularValorFinal() + pedido.calcularFrete()
        );

        System.out.println("--------------------------------");
    }
}