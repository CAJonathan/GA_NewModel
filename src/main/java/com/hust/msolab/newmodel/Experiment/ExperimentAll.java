package com.hust.msolab.newmodel.Experiment;

import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.Utils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExperimentAll {

    public static void main(String[] args) throws InterruptedException{
        Utils.cloneDirectory(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER);
        System.out.println("Creating directory...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Directory created!");
        System.out.println("Running Experiment:");

        run(Factors.INPUT_FOLDER);
    }

    private static void run(String dataFolder){
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String inputFilePath = subFile.getAbsolutePath();
                String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER).replace(".", "-result.");
                Experiment.run(inputFilePath, outputFilePath);
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }

}
