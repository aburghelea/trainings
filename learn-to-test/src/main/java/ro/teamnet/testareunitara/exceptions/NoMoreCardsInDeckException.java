package ro.teamnet.testareunitara.exceptions;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 11:08 AM
 */
public class NoMoreCardsInDeckException extends IllegalStateException {
    public NoMoreCardsInDeckException(String s) {
        super(s);
    }

}
