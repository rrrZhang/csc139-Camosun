package exceptions;

/**
 * InvalidNameException.java This program throws the exceptions
 * 
 * @param n Describes the string what is the error
 * 
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class InvalidNameException extends RuntimeException {

    public InvalidNameException(String n) {
        super(n);
    }

}



