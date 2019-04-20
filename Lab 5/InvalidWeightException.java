package exception;

/**
 * InvalidWeightException.java This program throws the exceptions
 * 
 * @param w Describes the string what is the error
 * 
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class InvalidWeightException extends RuntimeException{
    
    public InvalidWeightException(String w){
        super(w);     
    }
    
}



