package movies.exceptions;

public class MovieRentalException extends RuntimeException{
    public MovieRentalException(String message) {
        super(message);
    }
}
