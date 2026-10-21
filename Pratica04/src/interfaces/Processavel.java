package interfaces;

import exceptions.PedidoInvalidoException;

public interface Processavel {
  public abstract void processarPedido() throws PedidoInvalidoException;
  public abstract double calcularValorFinal();
}
