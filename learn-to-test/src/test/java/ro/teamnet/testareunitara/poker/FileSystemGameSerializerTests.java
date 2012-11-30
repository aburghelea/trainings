package ro.teamnet.testareunitara.poker;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.teamnet.testareunitara.CoreTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: iceman
 * Date: 8/24/12
 * Time: 1:40 PM
 */
public class FileSystemGameSerializerTests extends CoreTest {

    private GameSerializer gameSerializer;
    private File output;

    @Before
    public void setUp() throws Exception {
        output = new File("test.resultsd");
        gameSerializer = new FileSystemGameSerializer(output.getName());
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.deleteQuietly(output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWriteString() throws Exception {
        String EMPTY_STRING = "";
        gameSerializer.writeString(EMPTY_STRING);

        Assert.fail("The serializer wrote an empty string");
    }

    @Test
    public void testValidOneLiner() throws Exception {
        List<String> ONE_LINER = new ArrayList<>();
        ONE_LINER.add("Bow before me");

        List<String> fileContents = writeThis(ONE_LINER);

        assertFileContentsAreIdentical(ONE_LINER, fileContents);
    }

    @Test
    public void testValidForMultiLiner() throws Exception {
        List<String> MULTI_LINER = new ArrayList<>();
        MULTI_LINER.add("Bow before me");
        MULTI_LINER.add("for I am");
        MULTI_LINER.add("ROOT");

        List<String> fileContents = writeThis(MULTI_LINER);

        assertFileContentsAreIdentical(MULTI_LINER, fileContents);
    }

    private List<String> writeThis(List<String> stringList) throws IOException {
        for (String line : stringList)
            gameSerializer.writeString(line);

        return FileUtils.readLines(output);
    }

    private void assertFileContentsAreIdentical(List<String> one_liner, List<String> fileContents) {
        String status = "";
        if (one_liner.size() != fileContents.size())
            status = "Line numbers differ";
        else
            for (int i = 0; i < one_liner.size(); i++) {
                if (!one_liner.get(i).equals(fileContents.get(i))) {
                    status = "Files differ";
                }
            }

        Assert.assertTrue(status, "".equals(status));
    }
}
