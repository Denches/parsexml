package com.exhomework.domain;

import com.exhomework.comparator.Comparator;

import java.util.ArrayList;
import java.util.List;

import static com.exhomework.constant.XConstant.SPLIT_DIR;

public class PathToFilePrinter {

    private final Comparator comparator;

    private boolean isFile;
    private final List<String> dir = new ArrayList<>();

    public PathToFilePrinter(Comparator comparator) {
        this.comparator = comparator;
    }

    public void store(String name){

        if(isFile){
            if (comparator.compare(name)){
                print(name, getCurDir());
            }
        } else{
            setDir(name);
        }
    }

    private void print(String filename, String dir){
        System.out.println(dir + SPLIT_DIR + filename);
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
        dir.add(dir.size() > 1 ? SPLIT_DIR + name : name);
    }
}
