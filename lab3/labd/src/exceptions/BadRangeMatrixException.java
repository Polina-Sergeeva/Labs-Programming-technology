package exceptions;

public class BadRangeMatrixException extends Exception {
	final private String message;
	public BadRangeMatrixException (String e) {
		message = e;
	}

	final public String getMessage () {
		return message;
	}
}