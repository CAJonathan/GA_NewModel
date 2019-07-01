package com.hust.msolab.newmodel.INMA.Experiment;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Framework;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;

public class Experiment {

    public static void main(String[] args) {
        run(Factors.INPUT_FILE_PATH, Factors.OUTPUT_FILE_PATH);
    }

    public static void run(String inputFilePath, String outputFilePath){
        try{
            System.out.println(inputFilePath);
            INMAFileIO fileIO = new INMAFileIO();
            Framework framework = new Framework(inputFilePath);
            framework.solve();
            fileIO.output(framework.getSchedule(), framework.getNumOfDeaths(), framework.getExecutionTime(), outputFilePath);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
