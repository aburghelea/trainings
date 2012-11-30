package ro.teamnet.testareunitara.poker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * User: iceman
 * Date: 8/23/12
 * Time: 4:43 PM
 */
public class FileSystemGameSerializer implements GameSerializer {
    private static final Log log = LogFactoryImpl.getLog(FileSystemGameSerializer.class);
    private String fileName;
    private PrintWriter printWriter;

    public FileSystemGameSerializer(String fileName) {
        this.fileName = fileName;
        try {
            printWriter = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            log.error("Fisier inexistent " + e);
        }
    }

    @Override
    public void writeString(String toWrite) {
        if (fileName == null)
            throw new IllegalArgumentException("The fileName can not be null");

        if (toWrite == null || toWrite.trim().equals(""))
            throw new IllegalArgumentException("I don't write empty strings");

        printWriter.println(toWrite);
        printWriter.flush();
    }

}
