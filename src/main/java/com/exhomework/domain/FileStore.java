package com.exhomework.domain;

import java.util.ArrayList;
import java.util.List;

import static com.exhomework.constant.XConstant.SPLIT_DIR;

public abstract class FileStore {
    private boolean isFile;
    private final List<String> dir = new ArrayList<>();

    public void store(String name){

        if(isFile){
            if (compare(name)){
                print(name, getCurDir());
            }
        } else{
            setDir(name);
        }
    }

    private void print(String filename, String dir){
        System.out.println(dir + filename);
    }

    private String getCurDir() {
        return String.join("", dir);
    }

    public void closeDir(){
        dir.remove(dir.size() - 1);
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public void setDir(String name) {
        dir.add(!name.equals(SPLIT_DIR) ? name + SPLIT_DIR : name);
    }

    public abstract boolean compare(String filename);
}
