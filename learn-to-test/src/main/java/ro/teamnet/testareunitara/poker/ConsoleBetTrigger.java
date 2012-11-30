package ro.teamnet.testareunitara.poker;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 2:30 PM
 */
public class ConsoleBetTrigger implements BetTrigger {

    private final Scanner scanner = new Scanner(new BufferedInputStream(System.in));

    @Override
    public Integer trigger() {
        return scanner.nextInt();
    }
}
