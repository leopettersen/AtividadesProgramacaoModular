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

public class PedidoEletronicoTest {
  private PedidoEletronico pedido;

  @BeforeEach
  void setUp() {
    pedido = new PedidoEletronico(1, "Leo", 200.0, StatusPedido.PENDENTE);
  }

  @AfterEach
  void tearDown() {
    System.out.println("Teste finalizado");
  }

  @Test
  void valorFinalAcimaDe100DeveTer10PorCentoDeDesconto() {
    assertEquals(180.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void valorFinalIgualA100NaoDeveTerDesconto() {
    pedido.setValor(100.0);
    assertEquals(100.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void valorFinalAbaixoDe100NaoDeveTerDesconto() {
    pedido.setValor(50.0);
    assertEquals(50.0, pedido.calcularValorFinal(), 0.001);
  }

  @Test
  void freteDeveSer20MaisDezPorCentoDoValor() {
    assertEquals(40.0, pedido.calcularFrete(), 0.001);
  }

  @Test
  void categoriaDeveSerEletronicoEEntregavel() {
    assertEquals(Categoria.ELETRONICO, pedido.getCategoria());
    assertTrue(pedido instanceof Entregavel);
  }

  @Test
  void construtorComValorInvalidoDeveLancarValorInvalidoException() {
    assertThrows(ValorInvalidoException.class,
        () -> new PedidoEletronico(2, "Ana", 0, StatusPedido.PENDENTE));
    assertThrows(IllegalArgumentException.class,
        () -> new PedidoEletronico(3, "Ana", -5, StatusPedido.PENDENTE));
  }
}