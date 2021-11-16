package com.exhomework.parser;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.*;

import static com.exhomework.constant.XConstant.KEY_INPUT_FILE;

public class ReadXmlSaxParserTest {

    private ArgumentList argument;
    private ReadXmlSaxParser readXmlSaxParser;

    @BeforeEach
    void init(){
        readXmlSaxParser = new ReadXmlSaxParser();
    }

    @DisplayName("ArgumentList is not null")
    @Test
    void argumentListISNotNull(){
        argument = new ArgumentParser( new String[]{KEY_INPUT_FILE, "file.xml"});
        Assertions.assertDoesNotThrow(() -> readXmlSaxParser.parse(argument));
    }

    @DisplayName("ArgumentList is null")
    @Test
    void argumentListIsNull(){
        argument = null;
        Assertions.assertThrows(NullPointerException.class, () -> readXmlSaxParser.parse(argument));
    }

    @AfterEach
    void tearDown(){
        argument = null;
    }
}
