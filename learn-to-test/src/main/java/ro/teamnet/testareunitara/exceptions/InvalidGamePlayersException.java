package ro.teamnet.testareunitara.exceptions;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 11:37 AM
 */
public class InvalidGamePlayersException extends IllegalArgumentException {

    public InvalidGamePlayersException(String s) {
        super(s);
    }
}
