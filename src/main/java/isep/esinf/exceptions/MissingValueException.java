package isep.esinf.exceptions;

public class MissingValueException extends Exception {
  public MissingValueException() {
    super("This entry has missing values!");
  }

  public MissingValueException(String msg) {
    super(msg);
  }
}
