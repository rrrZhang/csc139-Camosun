package exception;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stephen
 */
public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String s) {
        super(s);
    }

}
