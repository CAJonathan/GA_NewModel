package com.hust.msolab.newmodel.INMA.ExperimentAll;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import com.hust.msolab.newmodel.INMA.Experiment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExperimentAll {

    public static void main(String[] args) throws IOException, InterruptedException{
        Utils.cloneDirectory(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER);
        System.out.println("Creating directory...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Directory created!");
        System.out.println("Running Experiment:");

        run(Factors.INPUT_FOLDER);
    }

    private static void run(String dataFolder) throws IOException {
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String inputFilePath = subFile.getAbsolutePath();
                String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER)
                        .replace(".", "-inmaresult.");
                Utils.copyContent(inputFilePath, outputFilePath);
                Experiment.run(inputFilePath, outputFilePath);
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }
}
