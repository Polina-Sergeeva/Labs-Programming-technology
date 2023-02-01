package exceptions;

public class NonSuitableMatrixException extends Exception {
	final private String message;
	public NonSuitableMatrixException (String e) {
		message = e;
	}

	final public String getMessage () {
		return message;
	}
}