package com.exhomework.parser;

import com.exhomework.exception.ArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.exhomework.constant.XConstant.*;

public class ArgumentParserTest {

    @DisplayName("Test without arguments")
    @Test
    void noArguments(){
        Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(new String[0]));
    }

    @DisplayName("Test with two incorrect arguments")
    @Test
    void twoIncorrectArguments(){
        Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(
                new String[]{"-q", "unknown.xml"}));
    }

    @DisplayName("Test with missed argument")
    @Test
    void missedArgument(){
        Assertions.assertThrows(ArgumentException.class, () -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE}));
    }

    @DisplayName("Test with two correct arguments")
    @Test
    void twoArguments(){
        Assertions.assertDoesNotThrow(() -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml"}));
    }

    @DisplayName("Test with three arguments")
    @Test
    void threeArguments(){
        Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK}));
    }

    @DisplayName("Test with four correct arguments")
    @Test
    void fourArguments(){
        Assertions.assertDoesNotThrow(() -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK, "'*.java'"}));
    }

    @DisplayName("Test not supported search mask")
    @Test
    void notSupportedSearchMask(){
        Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK_REGULAR, "'1"}));
    }

    @DisplayName("Test more than four arguments")
    @Test
    void moreThanFourArguments(){
        Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "file.xml", KEY_MACK_REGULAR, "test.java", "test"}));
    }

    @DisplayName("File is not exist")
    @Test
    void FileIsNotExist(){
        Assertions.assertThrows(ArgumentException.class,
                () -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "1.xml"}));
    }

    @DisplayName("File is exist")
    @Test
    void FileIsExist(){
        Assertions.assertDoesNotThrow(() -> new ArgumentParser(
                        new String[]{KEY_INPUT_FILE, "file.xml"}));
    }
}
