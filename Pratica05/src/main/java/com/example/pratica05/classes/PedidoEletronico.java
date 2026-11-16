package classes;

import enums.Categoria;
import enums.StatusPedido;
import interfaces.Entregavel;

public class PedidoEletronico extends Pedido implements Entregavel {

  public PedidoEletronico(int id, String nomeCliente, double valor, StatusPedido status) {
    super(id, nomeCliente, valor, status, Categoria.ELETRONICO);
  }

  public double calcularValorFinal() {
    if (getValor() > 100) {
      return getValor() * 0.9;
    }
    return getValor();
  }

  public double calcularFrete() {
    return (20.0 + getValor() * 0.1);
  }
  
}
