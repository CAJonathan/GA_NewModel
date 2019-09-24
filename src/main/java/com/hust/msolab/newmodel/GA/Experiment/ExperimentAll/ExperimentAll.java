package com.hust.msolab.newmodel.GA.Experiment.ExperimentAll;

import com.hust.msolab.newmodel.GA.Experiment.Experiment;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import scala.xml.Null;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Chạy thực nghiệm thuật toán GA trên tất cả các file trong folder dữ liệu
 *
 * @author sondn on 05/05/2019
 */

public class ExperimentAll {

    public static void main(String[] args) throws InterruptedException, IOException, NullPointerException{
        Utils.cloneDirectory(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER);
        System.out.println("Creating directory...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Directory created!");
        System.out.println("Running Experiment:");

        run(Factors.INPUT_FOLDER);
    }

    private static void run(String dataFolder) throws IOException, NullPointerException {
        File folder = new File(dataFolder);

        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String inputFilePath = subFile.getAbsolutePath();
                String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER)
                                                     .replace(".", "-result.");
                Utils.copyContent(inputFilePath, outputFilePath);
                Experiment.run(inputFilePath, outputFilePath);
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }

}
