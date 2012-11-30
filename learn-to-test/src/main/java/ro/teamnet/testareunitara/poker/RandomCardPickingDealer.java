package ro.teamnet.testareunitara.poker;

import ro.teamnet.testareunitara.exceptions.NoMoreCardsInDeckException;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 11:00 AM
 */
public class RandomCardPickingDealer implements Dealer {
    private List<Integer> deck;
    private final Random randomGenerator = new Random();

    public RandomCardPickingDealer() {
        deck = new LinkedList<>();
        for (int i = 0; i < 52; i++)
            deck.add(i / 4 + 2);
    }

    @Override
    public int deal() throws NoMoreCardsInDeckException {
        if (deck.size() <= 0) {
            throw new NoMoreCardsInDeckException("There are no more cards in the deck");
        }
        int cardIndex = pickCardIndex();

        return deck.remove(cardIndex);
    }

    private int pickCardIndex() {
        return randomGenerator.nextInt(deck.size());
    }
}
