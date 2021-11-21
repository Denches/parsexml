package com.exhomework.domain;

import java.util.*;

import static com.exhomework.constant.XConstant.SPLIT_DIR;

public class FileStore {
    private boolean isFile;
    private final Stack<String> dir = new Stack<>();

    private void print(String filename, String dir){
        System.out.println(dir + filename);
    }

    protected String getCurDir() {
        return String.join("", dir);
    }

    public void closeDir(){
        dir.pop();
    }

    public void store(String name, boolean equal){

        if(isFile()){
            if (equal){
                print(name, getCurDir());
            }
        } else{
            setDir(name);
        }
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public void setDir(String name) {
        dir.push(!name.equals(SPLIT_DIR) ? name + SPLIT_DIR : name);
    }
}
