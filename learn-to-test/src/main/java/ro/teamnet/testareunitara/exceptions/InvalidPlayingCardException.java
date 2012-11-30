package ro.teamnet.testareunitara.exceptions;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 10:49 AM
 */
public class InvalidPlayingCardException extends IllegalArgumentException {
    public InvalidPlayingCardException(String s) {
        super(s);
    }
}
