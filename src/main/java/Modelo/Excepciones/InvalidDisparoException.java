package Modelo.Excepciones;

public class InvalidDisparoException extends Exception {
    public InvalidDisparoException() {
        super("*Disparo Invalido*");
    }
    public InvalidDisparoException(String message) {
        super(message);
    }
}
