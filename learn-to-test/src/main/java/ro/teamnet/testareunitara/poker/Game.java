package ro.teamnet.testareunitara.poker;

import ro.teamnet.testareunitara.exceptions.InvalidGamePlayersException;
import ro.teamnet.testareunitara.exceptions.InvalidPlayerNameException;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 11:35 AM
 */
public class Game {

    private Player one, two;
    private Integer betTwo = 0;
    private Integer betOne = 0;

    public Game(Player one, Player two) {

        if (one == null || two == null)
            throw new InvalidGamePlayersException("Players are not allowed  null");

        if (one.getName().equals(two.getName()))
            throw new InvalidPlayerNameException("Can't have two player with same name");

        this.one = one;
        this.two = two;
    }

    Player getWinner() {
        if (isDraw())
            throw new IllegalStateException("Cant both win");
        Player winner;
        winner = getWinnerForPair();
        if (winner == null)
            if (one.getHighCard().compareTo(two.getHighCard()) > 0)
                winner = one;
            else if (one.getLowCard().compareTo(two.getLowCard()) > 0)
                winner = one;
            else
                winner = two;
        return winner;
    }

    private Player getWinnerForPair() {
        Player winner = null;
        if (one.hasPair() && !two.hasPair())
            winner = one;
        if (two.hasPair() && !one.hasPair())
            winner = two;
        if (one.hasPair() && two.hasPair()) {
            if (one.getFirstCard().compareTo(two.getFirstCard()) > 0)
                winner = one;
            else
                winner = two;
        }
        return winner;
    }

    Boolean isDraw() {
        return one.getFirstCard().equals(two.getFirstCard()) && one.getSecondCard().equals(two.getSecondCard());
    }

    public void deal() {
        one.deal();
        two.deal();
    }

    public String evaluate() {
        if (isDraw())
            return "It's a draw";

        return "Player " + getWinner().getName() + " won " + (betOne + betTwo) + " with " + getWinner().getFirstCard() + " - " + getWinner().getSecondCard();
    }

    public void save(GameSerializer gameSerializer) {
        String result = evaluate();

        gameSerializer.writeString(result);
    }

    public void collectBets(BetTrigger betTrigger) {
        betOne = one.bet(betTrigger);
        betTwo = two.bet(betTrigger);
    }


}
