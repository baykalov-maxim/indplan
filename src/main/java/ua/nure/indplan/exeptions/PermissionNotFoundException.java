package ua.nure.indplan.exeptions;

public class PermissionNotFoundException extends Exception {

	private static final long serialVersionUID = -8538235865662740710L;

	public PermissionNotFoundException() {
    }

    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(Throwable cause) {
        super(cause);
    }

    public PermissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionNotFoundException(String message, Throwable cause,
                                       boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}