package ro.teamnet.testareunitara.poker;

import org.junit.Assert;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 3:01 PM
 */
@SuppressWarnings("UnusedDeclaration")
public class GameSerializerMock implements GameSerializer {

    public String expectedString;
    public boolean writeStringWasCalled;

    @Override
    public void writeString(String toWrite) {
        Assert.assertEquals(expectedString, toWrite);
        writeStringWasCalled = true;
    }

}
