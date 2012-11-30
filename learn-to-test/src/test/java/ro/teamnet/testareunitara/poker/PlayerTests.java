package ro.teamnet.testareunitara.poker;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.teamnet.testareunitara.CoreTest;
import ro.teamnet.testareunitara.exceptions.InvalidPlayingCardException;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 10:28 AM
 */

public class PlayerTests extends CoreTest {
    private static Dealer dealerStub;

    @BeforeClass
    public static void initSuite() {
        dealerStub = new DealerStub();
        ((DealerStub) dealerStub).cardToReturn = 5;
    }

    @Test
    public void testNewPlayerWithValidNameAndDealer() {
        String name = "Maverick";
        Player player = new Player(name, dealerStub);

        Assert.assertEquals(name, player.getName());
    }

    @Test
    public void testNewGameWithInvalidNameAndValidDealer() {
        boolean thrownException = false;
        try {
            new Player(null, dealerStub);
        } catch (IllegalArgumentException e) {
            thrownException = true;
        }
        Assert.assertTrue(thrownException);
    }


    @Test
    public void testNewPlayerWithNameAndValidDealer() throws Exception {
        Player player = new Player("Maverick", dealerStub);

        Assert.assertNotNull("Dealerul when home", player.getFirstCard());
    }

    @Test(expected = InvalidPlayingCardException.class)
    public void testNewPlayerWithNullDealer() throws Exception {
        new Player("Maverick", null);

        Assert.fail("Player was initialized with null dealerStub");
    }


}
