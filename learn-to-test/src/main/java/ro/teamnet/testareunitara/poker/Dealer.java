package ro.teamnet.testareunitara.poker;

import ro.teamnet.testareunitara.exceptions.NoMoreCardsInDeckException;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 1:53 PM
 */
public interface Dealer {

    int deal() throws NoMoreCardsInDeckException;
}
