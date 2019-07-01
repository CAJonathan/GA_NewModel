package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Experiment.Experiment;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;

import java.io.File;
import java.io.IOException;

public class Scenario3 extends Scenario {

    Double[] energys;

    public void initFixedValues(){
        energys = new Double[]{40000.0, 60000.0, 80000.0, 100000.0};
    }

    public void run(String dataFolder) throws IOException {
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String fileName = subFile.getName();
                if(fileName.contains(100 + "-") || fileName.contains(100 + ".")){
                    String inputFilePath = subFile.getAbsolutePath();
                    String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER)
                            .replace(".", "-result.");
                    Utils.copyContent(inputFilePath, outputFilePath);
                    for(Double e : energys){
                        Factors.WCE_Emc = e;
                        Experiment.run(inputFilePath, outputFilePath);
                    }
                }
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }
}
