package com.exhomework.parser;

import com.exhomework.exception.ArgumentException;
import com.exhomework.domain.ArgumentList;

import java.io.File;

import static com.exhomework.constant.XConstant.*;

public class ArgumentParser extends ArgumentList {

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

        if (args[1] == null || args[1].trim().equals("")){
            throw new ArgumentException("input file doesn't exists");
        }

        if (args.length == 2){
            return;
        }

        if (args.length == 3){
            throw new ArgumentException("not found search parameter");
        }

        if (KEY_MACK.equals(args[2]) || KEY_MACK_REGULAR.equals(args[2])){
            if (args[3].startsWith(SINGLE_QUOTE)){
                if (args[3].length() < 3 || !args[3].endsWith(SINGLE_QUOTE)) {
                    throw new ArgumentException("not supported search mask:" + args[3]);
                }
            }

        }

        if (!(KEY_MACK.equals(args[2]) || KEY_MACK_REGULAR.equals(args[2]))){
                throw new ArgumentException("not supported key:" + args[2]);
        }


        if (args.length > 4) {
            throw new ArgumentException("too much parameters");
        }
    }

    private void storeParams(String[] args){
        setInputFileName(fileExists(args[1]));

        if (args.length > 2){
            if (KEY_MACK_REGULAR.equals(args[2])){
               setSearchType(SearchType.Regular);

            } else if (KEY_MACK.equals(args[2])){
                if (args[3].startsWith(SINGLE_QUOTE)){
                    setSearchType(SearchType.Mask);
                }else {
                    setSearchType(SearchType.Equals);
                }
            }

            if (args[3].startsWith(SINGLE_QUOTE)){
                setMask(args[3].replaceAll(SINGLE_QUOTE, ""));
            }else {
                setMask(args[3]);
            }
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
}