package ro.teamnet.testareunitara.poker;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.teamnet.testareunitara.CoreTest;
import ro.teamnet.testareunitara.exceptions.InvalidGamePlayersException;
import ro.teamnet.testareunitara.exceptions.InvalidPlayerNameException;
import ro.teamnet.testareunitara.exceptions.InvalidPlayingCardException;

import static org.mockito.Mockito.*;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 11:39 AM
 */
public class GameTests extends CoreTest {

    private Dealer dealerTwoStub;
    private Dealer dealerOneStub;
    GameSerializer gameSerializerMock;
    private BetTrigger betTrigger;

    @Before
    public void setUp() throws Exception {
        gameSerializerMock = mock(GameSerializer.class);
    }

    @Test(expected = InvalidGamePlayersException.class)
    public void testNewGameWithNullPlayers() throws Exception {
        new Game(null, null);
        new Game(new Player("gigi", null), null);
        new Game(null, new Player("gigi", null));

        Assert.fail("No player can be null");
    }

    @Test
    public void testFirstPlayerLosesHighCard() throws Exception {
        initDealers(3, 2, 5, 4);
        Player one = new Player("One", dealerOneStub);
        Player two = new Player("two", dealerTwoStub);

        Game game = new Game(one, two);

        Assert.assertEquals("Player One has won, nooo", two, game.getWinner());
    }

    @Test
    public void testFirstPlayerWinsHighCard() throws Exception {
        initDealers(3, 5, 1, 1);

        Player one = new Player("One", dealerTwoStub);
        Player two = new Player("two", dealerOneStub);

        Game game = new Game(one, two);

        Assert.assertEquals("Player One has lost", one, game.getWinner());
    }

    @Test(expected = IllegalStateException.class)
    public void testNoWinnerForSameCardsWithNoPair() throws Exception {
        initDealers(3, 2, 3, 2);

        Game game = gameWithTwoPlayers();

        game.getWinner();
    }

    @Test(expected = InvalidPlayerNameException.class)
    public void testNoGameForPlayersWithSameName() throws Exception {
        initDealers(1, 1, 1, 1);
        Player one = new Player("One", dealerOneStub);
        Player two = new Player("One", dealerOneStub);

        new Game(one, two);

        Assert.fail("Can't have two players with same name");
    }

    @Test
    public void testIsDrawForSameCard() throws Exception {
        initDealers(3, 2, 3, 2);

        Game game = gameWithTwoPlayers();

        Assert.assertTrue("It's not a tie", game.isDraw());
    }

    @Test
    public void testIsNotDrawForDifferentCards() throws Exception {
        initDealers(3, 1, 5, 2);

        Game game = gameWithTwoPlayers();

        Assert.assertFalse("It's a tie", game.isDraw());
    }

    @Test(expected = InvalidPlayingCardException.class)
    public void testDealNullCardsForBothPlayers() throws Exception {
        Player one = new Player("One", null);
        Player two = new Player("two", null);
        Game game = new Game(one, two);

        game.deal();

        Assert.fail("Null Cards were dealed");
    }

    @Test
    public void testEvaluateWhenIsDraw() throws Exception {
        initDealers(3, 3, 3, 3);
        Game game = gameWithTwoPlayers();

        Assert.assertEquals("Both players have 3", "It's a draw", game.evaluate());
    }


    @Test
    public void testEvaluateWhenPlayerOneWinsWithThree() throws Exception {
        initDealers(3, 1, 2, 1);
        Game game = gameWithTwoPlayers();

        Assert.assertEquals("Player One shoud win 3 to 2", "Player One won 0 with 3 - 1", game.evaluate());
    }

    @Test
    public void testFirstPlayerWinsWithPair() throws Exception {
        initDealers(3, 3, 2, 14);
        Game game = gameWithTwoPlayers();

        Assert.assertEquals("Player One shoud win 3 to 2", "Player One won 0 with 3 - 3", game.evaluate());
    }

    @Test
    public void testFirstPlayerWinsWithBiggerPair() throws Exception {
        initDealers(3, 3, 2, 2);
        Game game = gameWithTwoPlayers();

        Assert.assertEquals("Player One shoud win 3 to 2", "Player One won 0 with 3 - 3", game.evaluate());
    }

    @Test
    public void testGameIsDrawWithPairs() throws Exception {
        initDealers(7, 7, 7, 7);
        Game game = gameWithTwoPlayers();

        Assert.assertTrue("All players have only 7", game.isDraw());
    }

    @Test
    public void testSaveGameForPlayerOneWinning() throws Exception {
        initDealers(7, 1, 4, 2);
        Game game = gameWithTwoPlayers();

        game.save(gameSerializerMock);

        verify(gameSerializerMock).writeString("One won");
    }

    @Test
    public void testSaveGameForPlayerTwoWinning() throws Exception {
        initDealers(4, 2, 7, 2);
        Game game = gameWithTwoPlayers();

        game.save(gameSerializerMock);

        verify(gameSerializerMock).writeString("two won");
    }

    @Test
    public void testSaveGameForDraw() throws Exception {
        initDealers(3, 2, 3, 2);
        Game game = gameWithTwoPlayers();

        game.save(gameSerializerMock);

        verify(gameSerializerMock).writeString("Draw");
    }

    private Game gameWithTwoPlayers() {
        Player one = new Player("One", dealerOneStub);
        Player two = new Player("two", dealerTwoStub);

        return new Game(one, two);
    }

    private void initDealers(int returnByFirstFirstTime,
                             int returnByFirstSecondTime,
                             int returnBySecondFirstTime,
                             int returnBySecondSecondTime) {

        dealerOneStub = mock(Dealer.class);
        dealerTwoStub = mock(Dealer.class);

        when(dealerOneStub.deal()).thenReturn(returnByFirstFirstTime).thenReturn(returnByFirstSecondTime);
        when(dealerTwoStub.deal()).thenReturn(returnBySecondFirstTime).thenReturn(returnBySecondSecondTime);
    }

    @Test
    public void testIfGameCollectsFromBothPlayers() throws Exception {
        initInputMethod();
        initDealers(4, 5, 5, 2);
        Game game = gameWithTwoPlayers();
        game.collectBets(betTrigger);

        verify(betTrigger, times(2)).trigger();
    }

    private void initInputMethod() {
        betTrigger = mock(BetTrigger.class);

        when(betTrigger.trigger()).thenReturn(100, 299, 100, 50, 10000, 2000, 300, 300);
    }
}
