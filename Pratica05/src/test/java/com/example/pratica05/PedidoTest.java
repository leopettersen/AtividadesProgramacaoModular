package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
  private List<Pedido> pedidos;

  @BeforeEach
  void setUp() {
    pedidos = List.of(
        new PedidoEletronico(1, "Ana", 150.0, StatusPedido.PENDENTE),
        new PedidoRoupa(2, "Bia", 250.0, StatusPedido.PENDENTE),
        new PedidoAlimento(3, "Caio", 40.0, StatusPedido.PENDENTE));
  }

  @AfterEach
  void tearDown() {
    System.out.println("Teste finalizado");
  }

  @Test
  void setStatusDeveAlterarStatus() {
    for (Pedido p : pedidos) {
      p.setStatus(StatusPedido.ENVIADO);
      assertEquals(StatusPedido.ENVIADO, p.getStatus());
    }
  }

  @Test
  void processarPedidoDeveAlterarStatusParaProcessando() {
    for (Pedido p : pedidos) {
      p.processarPedido();
      assertEquals(StatusPedido.PROCESSANDO, p.getStatus());
    }
  }

  @Test
  void processarPedidoCanceladoDeveLancarPedidoInvalidoException() {
    for (Pedido p : pedidos) {
      p.setStatus(StatusPedido.CANCELADO);
      PedidoInvalidoException ex =
          assertThrows(PedidoInvalidoException.class, p::processarPedido);
      assertEquals("Pedido cancelado não pode ser processado!", ex.getMessage());
      assertEquals(StatusPedido.CANCELADO, p.getStatus());
    }
  }

  @Test
  void pedidoEntregueNaoPodeTerStatusAlterado() {
    for (Pedido p : pedidos) {
      p.setStatus(StatusPedido.ENTREGUE);
      for (StatusPedido novo : StatusPedido.values()) {
        PedidoInvalidoException ex =
            assertThrows(PedidoInvalidoException.class, () -> p.setStatus(novo));
        assertEquals("Pedido entregue não pode mudar de status!", ex.getMessage());
        assertEquals(StatusPedido.ENTREGUE, p.getStatus());
      }
    }
  }

  @Test
  void processarPedidoEntregueDeveLancarPedidoInvalidoException() {
    for (Pedido p : pedidos) {
      p.setStatus(StatusPedido.ENTREGUE);
      assertThrows(PedidoInvalidoException.class, p::processarPedido);
      assertEquals(StatusPedido.ENTREGUE, p.getStatus());
    }
  }

  @Test
  void setValorInvalidoDeveLancarValorInvalidoException() {
    for (Pedido p : pedidos) {
      assertThrows(ValorInvalidoException.class, () -> p.setValor(0));
      assertThrows(ValorInvalidoException.class, () -> p.setValor(-10));
    }
  }

  @Test
  void excecoesPersonalizadasDevemSerExcecoesDoJava() {
    Pedido p = pedidos.get(0);
    p.setStatus(StatusPedido.ENTREGUE);
    assertThrows(IllegalStateException.class, () -> p.setStatus(StatusPedido.PENDENTE));
    assertThrows(IllegalArgumentException.class, () -> p.setValor(-1));
  }

  @Test
  void statusNuloDeveLancarNullPointerException() {
    Pedido p = new PedidoAlimento(4, "Dani", 10.0, null);
    assertThrows(NullPointerException.class, p::processarPedido);
    assertThrows(NullPointerException.class, () -> p.setStatus(StatusPedido.PENDENTE));
  }
}