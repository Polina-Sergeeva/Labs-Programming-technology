package exceptions;

public class WrongMatrixSizeException extends RuntimeException {
	final private String message;
	public WrongMatrixSizeException (String e) {
		message = e;
	}

	final public String getMessage () {
		return message;
	}
}