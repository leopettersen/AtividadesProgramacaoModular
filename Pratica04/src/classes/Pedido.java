package classes;

import enums.Categoria;
import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;
import interfaces.Processavel;

public abstract class Pedido implements Processavel {
  private int id;
  private String nomeCliente;
  private double valor;
  private StatusPedido status;
  private Categoria categoria;

  public Pedido(int id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) {
    if (valor <= 0) {
      throw new ValorInvalidoException("Valor menor ou igual a zero!");
    }

    this.id = id;
    this.nomeCliente = nomeCliente;
    this.valor = valor;
    this.status = status;
    this.categoria = categoria;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    if (valor <= 0) {
      throw new ValorInvalidoException("Valor menor ou igual a zero!");
    }
    this.valor = valor;
  }

  public StatusPedido getStatus() {
    return status;
  }

  public void setStatus(StatusPedido status) {
    switch (this.status) {
      case ENTREGUE:
        throw new PedidoInvalidoException("Pedido entregue não pode mudar de status!");
      default:
        break;
    }

    this.status = status;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void processarPedido() {
    switch (status) {
      case CANCELADO:
        throw new PedidoInvalidoException("Pedido cancelado não pode ser processado!");
      default:
        setStatus(StatusPedido.PROCESSANDO);
        break;
    }
  }

  public abstract double calcularValorFinal();

  public abstract double calcularFrete();
}