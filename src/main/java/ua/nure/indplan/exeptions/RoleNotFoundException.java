package ua.nure.indplan.exeptions;

public class RoleNotFoundException extends Exception {

	private static final long serialVersionUID = -8774722447656401834L;

	public RoleNotFoundException() {
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNotFoundException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
