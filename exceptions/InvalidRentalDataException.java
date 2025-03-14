package movies.exceptions;

public class InvalidRentalDataException extends MovieRentalException {
    public InvalidRentalDataException(String message) {
        super(message);
    }
}
