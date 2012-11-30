package ro.teamnet.testareunitara.poker;

import ro.teamnet.testareunitara.exceptions.InvalidPlayerNameException;
import ro.teamnet.testareunitara.exceptions.InvalidPlayingCardException;
import ro.teamnet.testareunitara.exceptions.NoMoreCardsInDeckException;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 9:31 AM
 */
public class Player {
    private String name;
    private Integer firstCard;
    private Integer secondCard;
    private Dealer dealer;

    public Player(String name, Dealer dealer) {
        if (name == null)
            throw new InvalidPlayerNameException("Name can't be null");

        if (dealer == null)
            throw new InvalidPlayingCardException("No dealer to give cards");

        this.name = name;
        this.dealer = dealer;
        deal();
    }

    public String getName() {
        return name;
    }

    public Integer getFirstCard() {
        return firstCard;
    }

    public Integer getSecondCard() {
        return secondCard;
    }

    public void deal() {
        try {
            firstCard = dealer.deal();
            secondCard = dealer.deal();
        } catch (NoMoreCardsInDeckException ignored) {
        }
    }

    public boolean hasPair() {
        return firstCard.equals(secondCard);
    }

    public Integer getHighCard() {
        return Math.max(firstCard, secondCard);
    }

    public Integer getLowCard() {
        return Math.min(firstCard, secondCard);
    }

    public Integer bet(BetTrigger betTrigger) {
        return betTrigger.trigger();
    }
}
