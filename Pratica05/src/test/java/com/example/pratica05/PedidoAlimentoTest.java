package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import enums.Categoria;
import enums.StatusPedido;
import exceptions.ValorInvalidoException;
import interfaces.Entregavel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoAlimentoTest {
  private PedidoAlimento pedido;

  @BeforeEach
  void setUp() {
    pedido = new PedidoAlimento(1, "Leo", 80.0, StatusPedido.PENDENTE);
  }

  @AfterEach
  void tearDown() {
    System.out.println("Teste finalizado");
  }

  @Test
  void valorFinalDeveSerIgualAoValorOriginal() {
    assertEquals(80.0, pedido.calcularValorFinal(), 0.001);
    pedido.setValor(500.0);
    assertEquals(500.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void freteDeveSerFixoEm5() {
    assertEquals(5.0, pedido.calcularFrete(), 0.001);
    pedido.setValor(500.0);
    assertEquals(5.0, pedido.calcularFrete(), 0.001);
  }

  @Test
  void categoriaDeveSerAlimentoENaoEntregavel() {
    assertEquals(Categoria.ALIMENTO, pedido.getCategoria());
    assertFalse(pedido instanceof Entregavel);
  }

  @Test
  void construtorComValorInvalidoDeveLancarValorInvalidoException() {
    assertThrows(ValorInvalidoException.class,
        () -> new PedidoAlimento(2, "Ana", 0, StatusPedido.PENDENTE));
    assertThrows(IllegalArgumentException.class,
        () -> new PedidoAlimento(3, "Ana", -5, StatusPedido.PENDENTE));
  }
}