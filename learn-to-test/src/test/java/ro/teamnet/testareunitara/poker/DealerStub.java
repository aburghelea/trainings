package ro.teamnet.testareunitara.poker;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 2:06 PM
 */
public class DealerStub implements Dealer {

    public int cardToReturn;

    @Override
    public int deal() {
        return cardToReturn;
    }
}
