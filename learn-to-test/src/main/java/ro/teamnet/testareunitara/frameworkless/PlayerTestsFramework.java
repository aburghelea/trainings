package ro.teamnet.testareunitara.frameworkless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import ro.teamnet.testareunitara.poker.Player;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 9:26 AM
 */
public class PlayerTestsFramework {
    private static final Log log = LogFactoryImpl.getLog(PlayerTestsFramework.class);

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual))
            throw new RuntimeException("Params not equal");
    }

    private static void assertTrue(boolean value) {
        if (!value)
            throw new RuntimeException("It was not true");
    }

    void testConstructorParameters() {
        String name = "Maverick";
        Player player = new Player(name, null);

        assertEquals(name, player.getName());
    }

    void testConstructorWithNullParameter() {
        boolean thrownException = false;
        try {
            new Player(null, null);
        } catch (IllegalArgumentException e) {
            log.info("Constructor parameters are not valid");
            thrownException = true;
        }
        assertTrue(thrownException);
    }

    public static void main(String[] args) {
        PlayerTestsFramework playerTests = new PlayerTestsFramework();
        try {
            playerTests.testConstructorParameters();
            playerTests.testConstructorWithNullParameter();
            log.info("Passed");
        } catch (Exception e) {
            log.fatal("Fail");
        } finally {
            log.info("DONE");
        }
    }
}
