package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ImplementScenario {
    private static Scenario scenario;

    public static void main(String[] args) throws IOException, InterruptedException {
        Utils.cloneDirectory(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER);
        System.out.println("Creating directory...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Directory created!");
        System.out.println("Running Experiment:");

        scenario = new Scenario2();
        scenario.initFixedValues();
        scenario.run(Factors.INPUT_FOLDER);
    }
}
