package com.hust.msolab.newmodel.GA.Utilities;

import java.io.File;

public class StandardizeFileName {

    public static void main(String[] args){
        String folder = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data7/Grid/";
        String notation = "gnu";

        File f = new File(folder);
        File[] files = f.listFiles();
        for(int i = 0 ; i < files.length ; i ++){
            files[i].renameTo(new File(folder + notation + "_" + (i < 9 ? ("0" + (i + 1)) : (i + 1))));
        }
    }
}
