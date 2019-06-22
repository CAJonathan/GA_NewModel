package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Experiment.Experiment;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;

import java.io.File;
import java.io.IOException;

public class Scenario1 extends Scenario {

    Integer[] numOfSensor;

    public void initFixedValues(){
        numOfSensor = new Integer[]{20, 40, 70, 100};
    }

    public void run(String dataFolder) throws IOException {
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String fileName = subFile.getName();
                boolean allowToRun = false;
                for(Integer num : numOfSensor){
                    if(fileName.contains(num.toString() + "-") || fileName.contains(num.toString() + ".")){
                        allowToRun = true;
                    }
                }

                if(allowToRun){
                    String inputFilePath = subFile.getAbsolutePath();
                    String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER)
                            .replace(".", "-result.");
                    Utils.copyContent(inputFilePath, outputFilePath);
                    Experiment.run(inputFilePath, outputFilePath);
                }
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }
}
