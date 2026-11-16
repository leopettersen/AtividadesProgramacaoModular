package exceptions;

public class PedidoInvalidoException extends IllegalStateException{

  public PedidoInvalidoException() {
    super();
  }

  public PedidoInvalidoException(String message) {
    super(message);
  }
  
}
