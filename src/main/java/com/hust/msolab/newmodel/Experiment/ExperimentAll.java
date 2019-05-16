package com.hust.msolab.newmodel.Experiment;

import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.Utils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ExperimentAll {

    public static void main(String[] args) throws IOException {
        String inputFolder = Factors.PATH_TO_RESOURCE + Factors.INPUT_FOLDER;
        String outputFolder = Factors.PATH_TO_RESOURCE + "Result/" + Factors.OUTPUT_FOLDER_NAME;
        FileUtils.copyDirectory(new File(inputFolder), new File(outputFolder));
        run(inputFolder);
    }

    private static void run(String dataFolder){
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String inputFilePath = subFile.getAbsolutePath();
                String outputFilePath = inputFilePath.replace("Data", "Result/" + Factors.OUTPUT_FOLDER_NAME).replace(".", "-result.");
                Experiment.run(inputFilePath, outputFilePath);
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }

}
