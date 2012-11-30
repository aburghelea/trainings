package ro.teamnet.testareunitara.poker;

import java.util.Random;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 1:54 PM
 */
public class UnlimitedCardsDealer implements Dealer {
    @Override
    public int deal() {
        Random random = new Random();
        return 2 + random.nextInt(13);
    }
}
