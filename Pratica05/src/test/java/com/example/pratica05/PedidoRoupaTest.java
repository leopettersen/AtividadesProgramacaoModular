package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import enums.Categoria;
import enums.StatusPedido;
import exceptions.ValorInvalidoException;
import interfaces.Entregavel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoRoupaTest {
  private PedidoRoupa pedido;

  @BeforeEach
  void setUp() {
    pedido = new PedidoRoupa(1, "Leo", 300.0, StatusPedido.PENDENTE);
  }

  @AfterEach
  void tearDown() {
    System.out.println("Teste finalizado");
  }

  @Test
  void valorFinalAcimaDe200DeveTer20PorCentoDeDesconto() {
    assertEquals(240.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void valorFinalIgualA200NaoDeveTerDesconto() {
    pedido.setValor(200.0);
    assertEquals(200.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void valorFinalAbaixoDe200NaoDeveTerDesconto() {
    pedido.setValor(100.0);
    assertEquals(100.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void freteDeveSer10MaisCincoPorCentoDoValor() {
    assertEquals(25.0, pedido.calcularFrete(), 0.001);
  }

  @Test
  void categoriaDeveSerRoupaEEntregavel() {
    assertEquals(Categoria.ROUPA, pedido.getCategoria());
    assertTrue(pedido instanceof Entregavel);
  }

  @Test
  void construtorComValorInvalidoDeveLancarValorInvalidoException() {
    assertThrows(ValorInvalidoException.class,
        () -> new PedidoRoupa(2, "Ana", 0, StatusPedido.PENDENTE));
    assertThrows(IllegalArgumentException.class,
        () -> new PedidoRoupa(3, "Ana", -5, StatusPedido.PENDENTE));
  }
}