package ro.teamnet.testareunitara.exceptions;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 10:06 AM
 */
public class InvalidPlayerNameException extends IllegalArgumentException {

    public InvalidPlayerNameException(String s) {
        super(s);
    }
}
