package fr.univrouen.cv24.util;

/**
 * Exception pour la validation d STB
 * @author Yeser GOUMIDI
 */

public class CVNotValidException extends Exception {

    public CVNotValidException(String message) {
        super(message);
    }
    
    public CVNotValidException(){
        super("Validation error");
    }
}
