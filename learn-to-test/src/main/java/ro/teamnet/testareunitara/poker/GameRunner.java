package ro.teamnet.testareunitara.poker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 11:39 AM
 */
public class GameRunner {
    /*
    Random card to both players;
     */

    private Game game;

    private static final Log log = LogFactoryImpl.getLog(GameRunner.class);

    public GameRunner(Game game) {
        if (game == null)
            throw new IllegalStateException("Start with a game");
        this.game = game;
    }

    public void runGame() {
        BetTrigger consoleBetTrigger = new ConsoleBetTrigger();
        for (int i = 0; i <= 9; i++) {
            game.deal();
            game.collectBets(consoleBetTrigger);
            String status = game.evaluate();
            System.out.println(status);
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                log.debug("Thread could not sleep");
            }
        }
    }

    public static void main(String[] args) {
        Dealer dealer = new RandomCardPickingDealer();
        GameRunner gameRunner = new GameRunner(new Game(new Player("Maverick", dealer), new Player("Iceman", dealer)));

        gameRunner.runGame();
    }
}
