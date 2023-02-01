package exceptions;

public class WrongMatrixIndexException extends RuntimeException {
	final private String message;
	public WrongMatrixIndexException (String e) {
		message = e;
	}

	final public String getMessage () {
		return message;
	}
}