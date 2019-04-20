package exception;

/**
 * EmptyContainerException.java This program throws the exceptions
 * 
 * @param container Describes the string what is the error
 * 
 * @author Rena Zhang
 * @vision 1.6
 * @since 2017-02-06
 */
public class EmptyContainerException extends RuntimeException {
    
    public EmptyContainerException (String container){
        super(container);
    }    
}






