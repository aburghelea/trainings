package ro.teamnet.testareunitara.poker;

import org.junit.Ignore;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 11:48 AM
 */
@Ignore
public class UnlimitedCardsDealerTest extends DealerTests {
    @Override
    protected Dealer createDealer() {
        return new UnlimitedCardsDealer();
    }
}
