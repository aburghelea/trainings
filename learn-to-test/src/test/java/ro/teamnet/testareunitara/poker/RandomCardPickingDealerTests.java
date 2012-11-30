package ro.teamnet.testareunitara.poker;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 11:45 AM
 */
public class RandomCardPickingDealerTests extends DealerTests {

    @Override
    protected Dealer createDealer() {
        return new RandomCardPickingDealer();
    }
}
