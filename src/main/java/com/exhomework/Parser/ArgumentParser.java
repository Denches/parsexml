package com.exhomework.Parser;

import com.exhomework.exception.ArgumentException;

import java.io.File;

import static com.exhomework.constant.XConstant.*;

public class ArgumentParser {

     private static String inputFileName;
     private static String mask;


    public ArgumentParser(String[] args) {
        validator(args);
        storeParams(args);
    }

    private void validator(String[] args){
        if (args == null || args.length < 2){
            throw new ArgumentException("too few parameters");
        }

        if (!KEY_INPUT_FILE.equals(args[0])){
            throw new ArgumentException("not supported key:" + args[0]);
        }
        if (args.length == 2){
            return;
        }
        if (args.length == 3){
            throw new ArgumentException("not found search parameter");
        }
        if (!(KEY_MACK.equals(args[2]) || KEY_MACK_REGULAR.equals(args[2]))){
            throw new ArgumentException("not supported key:" + args[2]);
        }

    }

    private void storeParams(String[] args){
        inputFileName = fileExists(args[1]);
        if (args.length > 3){
            mask = args[3].replaceAll("'", "");
        }

    }

    private String fileExists(String fileName) {
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

    public static String getMask() {
        return mask;
    }
}
