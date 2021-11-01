package com.exhomework.Parser;

import com.exhomework.exception.ArgumentException;

import java.io.File;

import static com.exhomework.constant.XConstant.*;

public class ArgumentParser {

     private static String inputFileName;
     private static String searchType;


    public ArgumentParser(String[] args) throws ArgumentException {
        validator(args);
        storeParams(args);
    }

    private void validator(String[] args) throws ArgumentException {

        if (!args[0].equals(KEY_INPUT_FILE)){
            throw new ArgumentException("not supported key:" + args[0]);
        }

        if (args.length > 2){
            if (!args[2].equals(KEY_MACK)){
                throw new ArgumentException("not supported key:" + args[2]);
            }
        }
    }

    private void storeParams(String[] args) throws ArgumentException {
        inputFileName = fileExists(args[1]);

        if (args.length > 3){
            searchType = args[3].replaceAll("'", "");
        }
    }

    private String fileExists(String fileName) throws ArgumentException {
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if(f.exists() && f.isFile()){
            return f.getAbsolutePath();
        }else{
            throw new ArgumentException("input file doesn't exists");
        }

    }

    public static String getInputFileName() {
        return inputFileName;
    }

    public static String getSearchType() {
        return searchType;
    }
}
