package exceptions;

/**
 * EmptyQueueException.java This program throws the exceptions
 *
 * @param w Describes the string what is the error
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-02-03
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String w) {
        super(w);
    }

}
