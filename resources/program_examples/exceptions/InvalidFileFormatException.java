import java.io.IOException;

public class InvalidFileFormatException extends IOException {
private static final long serialVersionUID = 739215413984656388L;

	public InvalidFileFormatException( String message ) {
		super( message );
	}
}
