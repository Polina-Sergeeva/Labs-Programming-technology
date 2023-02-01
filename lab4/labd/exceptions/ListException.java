package exceptions;

public class ListException extends RuntimeException {
	final private String message;
	public ListException (String e) {
		message = e;
	}

	final public String getMessage () {
		return message;
	}
}