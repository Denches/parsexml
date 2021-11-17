package com.exhomework.parser;

import com.exhomework.domain.ArgumentList;
import com.exhomework.exception.ArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.exhomework.constant.XConstant.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArgumentParserTest {

    @DisplayName("Test without arguments")
    @Test
    void noArguments(){
         Exception exception = Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(new String[0]));

         String expected = "too few parameters";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("Test with two incorrect arguments")
    @Test
    void twoIncorrectArguments(){
        Exception exception = Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(
                new String[]{"-q", "unknown.xml"}));

        String expected = "not supported key:-q";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("Test with missed argument")
    @Test
    void missedArgument(){
        Exception exception = Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE}));

        String expected = "too few parameters";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("Test with two correct arguments")
    @Test
    void twoArguments(){
        String expectedFileName = "file.xml";
        String expectedMask = null;
        SearchType expectedMaskType = SearchType.Full;

        ArgumentList argument = new ArgumentParser(new String[]{KEY_INPUT_FILE, "file.xml"});

        Assertions.assertAll(
                () -> assertNotNull(argument),
                () -> assertEquals(expectedFileName, argument.getInputFilename()),
                () -> assertEquals(expectedMask, argument.getMask()),
                () -> assertEquals(expectedMaskType,argument.getSearchType())
        );
    }

    @DisplayName("Test with three arguments")
    @Test
    void threeArguments(){
        Exception exception = Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK}));

        String expected = "not found search parameter";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("Test with four correct arguments")
    @Test
    void fourArguments(){
        String expectedFileName = "file.xml";
        String expectedMask = "*.java";
        SearchType expectedMaskType = SearchType.Mask;

        ArgumentList argument = new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK, "'*.java'"});

        Assertions.assertAll(
                () -> assertNotNull(argument),
                () -> assertEquals(expectedFileName, argument.getInputFilename()),
                () -> assertEquals(expectedMask, argument.getMask()),
                () -> assertEquals(expectedMaskType,argument.getSearchType())
        );
    }

    @DisplayName("Test not supported search mask")
    @Test
    void notSupportedSearchMask(){
        Exception exception = Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK_REGULAR, "'1"}));

        String expected = "not supported search mask:'1";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("Test more than four arguments")
    @Test
    void moreThanFourArguments(){
        Exception exception = Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK_REGULAR, "test.java", "test"}));

        String expected = "too much parameters";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("File doesn't exist")
    @Test
    void FileIsNotExist(){
        Exception exception = Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "1.xml"}));

        String expected = "input file doesn't exists";

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @DisplayName("File exists")
    @Test
    void FileIsExist(){
        String expectedFileName = "file.xml";

        ArgumentList argument = new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml"});

        Assertions.assertAll(
                () -> assertNotNull(argument),
                () -> assertEquals(expectedFileName, argument.getInputFilename())
        );
    }
}
