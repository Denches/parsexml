package com.exhomework;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @BeforeEach
    void init(){
        System.setOut(new PrintStream(baos));
    }

    @DisplayName("No search arguments")
    @Test
    void noSearchArguments(){
        Main.main(new String[]{"-f", "file.xml"});

        String expected = "/file-776194140.xml" + System.lineSeparator() +
                          "/dir-880176375/file-1073842118.java" + System.lineSeparator() +
                          "/dir-880176375/dir-2145307015/file-1498940214.xhtml" + System.lineSeparator();
        Assertions.assertEquals(expected, baos.toString());
    }

    @DisplayName("Equal search")
    @Test
    void equalSearch(){
        Main.main(new String[]{"-f", "file.xml", "-s", "file-1498940214.xhtml"});

        String expected = "/dir-880176375/dir-2145307015/file-1498940214.xhtml" + System.lineSeparator();
        Assertions.assertEquals(expected, baos.toString());
    }

    @DisplayName("Mask search")
    @Test
    void maskSearch(){
        Main.main(new String[]{"-f", "file.xml", "-s", "'*.java'"});

        String expected = "/dir-880176375/file-1073842118.java" + System.lineSeparator();
        Assertions.assertEquals(expected, baos.toString());
    }

    @DisplayName("Regular search")
    @Test
    void regularSearch(){
        Main.main(new String[]{"-f", "file.xml", "-S", "'.*?[a-z]{4}-\\d+\\.[a-z]+'"});

        String expected = "/file-776194140.xml" + System.lineSeparator() +
                          "/dir-880176375/file-1073842118.java" + System.lineSeparator() +
                          "/dir-880176375/dir-2145307015/file-1498940214.xhtml" + System.lineSeparator();
        Assertions.assertEquals(expected, baos.toString());
    }

    @AfterEach
    void rearDown(){
        System.setOut(printStream);
    }
}
