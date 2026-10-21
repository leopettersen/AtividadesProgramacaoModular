package exceptions;

public class ValorInvalidoException extends IllegalArgumentException {

  public ValorInvalidoException() {
    super();
  }

  public ValorInvalidoException(String message) {
    super(message);
  }

}
