package ro.teamnet.testareunitara.poker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.teamnet.testareunitara.CoreTest;
import ro.teamnet.testareunitara.exceptions.NoMoreCardsInDeckException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 10:59 AM
 */
public abstract class DealerTests extends CoreTest {

    Dealer dealer;

    protected abstract Dealer createDealer();

    @Before
    public void setUp() throws Exception {
        dealer = createDealer();
    }

    @Test
    public void testIfDealerGivesARealDeck() throws Exception {
        List<Integer> receivedDeck = requestFullDeck();

        assertReceivedDeckContainsAllCardsInRealDeck(receivedDeck);
    }

    @Test(expected = NoMoreCardsInDeckException.class)
    public void testIfDealerGivesMoreCardsThanInDeck() throws Exception {
        requestFullDeck();

        dealer.deal();

        Assert.fail("The dealer gave more cars than 52");
    }

    @Test
    public void testIfDealerGivesShuffledCards() throws Exception {
        List<Integer> firstDeck = requestFullDeck();
        dealer = new RandomCardPickingDealer();
        List<Integer> secondDeck = requestFullDeck();

        assertDecksAreDifferent(firstDeck, secondDeck);
    }


    private void assertDecksAreDifferent(List<Integer> firstDeck, List<Integer> secondDeck) {
        Assert.assertTrue("Decks are the same, dealer gives same cards", areDifferentDecks(firstDeck, secondDeck));
    }

    private boolean areDifferentDecks(List<Integer> firstDeck, List<Integer> secondDeck) {
        if (firstDeck.size() != 52 || secondDeck.size() != 52)
            return false;
        for (int i = 0; i < 52; i++) {
            if (firstDeck.get(i).compareTo(secondDeck.get(i)) != 0)
                return true;
        }
        return false;
    }

    private void assertReceivedDeckContainsAllCardsInRealDeck(List<Integer> receivedDeck) {
        Assert.assertTrue("This is not o correct deck (4x[2-14])", isAValidDeck(receivedDeck));
    }

    private boolean isAValidDeck(List<Integer> receivedDeck) {
        Collections.sort(receivedDeck);
        for (int i = 0; i < 52; i++) {
            if (receivedDeck.get(i) != (i / 4) + 2)
                return false;
        }
        return true;
    }

    private List<Integer> requestFullDeck() {
        List<Integer> receivedDeck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            receivedDeck.add(dealer.deal());
        }
        return receivedDeck;
    }
}
