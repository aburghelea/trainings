package ro.teamnet.testareunitara.poker;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.teamnet.testareunitara.CoreTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 3:23 PM
 */
public class EndToEnd extends CoreTest {

    private static final String SERIALIZER_TEST = "serializer.test";
    private BetTrigger betTrigger;
    private GameSerializer gameSerializer;
    private Game game;
    private Dealer dealer;


    @Before
    public void setUp() throws Exception {
        initBetTrigger();
        FileUtils.deleteQuietly(new File(SERIALIZER_TEST));
        gameSerializer = new FileSystemGameSerializer(SERIALIZER_TEST);
        initDealer();
        Player iceman = new Player("Iceman", dealer);
        Player maverick = new Player("Maverick", dealer);
        game = new Game(iceman, maverick);

    }

    private void initDealer() {
        dealer = mock(Dealer.class);
        when(dealer.deal()).thenReturn(2, 2, 2, 2,
                3, 2, 2, 2,
                5, 2, 4, 2,
                7, 4, 4, 7,
                9, 2, 5, 2,
                4, 5, 2, 5
        );
    }

    private void initBetTrigger() {
        betTrigger = mock(BetTrigger.class);
        Integer[] bets = {10,
                20, 20,
                5, 6,
        };
        when(betTrigger.trigger()).thenReturn(100, bets);
    }

    @Test
    public void testWholeSystem() throws Exception {
        for (int i = 0; i < 3; i++) {
            game.deal();
            game.collectBets(betTrigger);
            game.save(gameSerializer);
        }
        List<String> expectedLines = new ArrayList<>();

        expectedLines.add("Player Maverick won 110 with 2 - 2");
        expectedLines.add("Player Iceman won 40 with 5 - 2");
        expectedLines.add("Player Maverick won 11 with 4 - 7");
        List<String> actualLines = FileUtils.readLines(new File(SERIALIZER_TEST));

        assertLinesAreEqual(expectedLines, actualLines);
    }

    private void assertLinesAreEqual(List<String> expectedLines, List<String> actualLines) {
        boolean areEqual = true;
        if (expectedLines.size() != actualLines.size()) {
            areEqual = false;
        } else {
            for (int i = 0; i < expectedLines.size(); i++) {
                if (!expectedLines.get(i).equals(actualLines.get(i))) {
                    areEqual = false;
                }
            }


        }
        Assert.assertTrue("Game executed smuthli", areEqual);
    }
}
