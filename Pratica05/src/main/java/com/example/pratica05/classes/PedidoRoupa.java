package classes;

import enums.*;
import interfaces.Entregavel;

public class PedidoRoupa extends Pedido implements Entregavel {

  public PedidoRoupa(int id, String nomeCliente, double valor, StatusPedido status) {
    super(id, nomeCliente, valor, status, Categoria.ROUPA);
  }

  public double calcularValorFinal() {
    if (getValor() > 200) {
      return getValor() * 0.8;
    }
    return getValor();
  }

  public double calcularFrete() {
    return (10.0 + getValor() * 0.05);
  }
  
}