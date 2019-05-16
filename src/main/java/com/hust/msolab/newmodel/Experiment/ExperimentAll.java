package com.hust.msolab.newmodel.Experiment;

import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.Utils;

import java.io.File;

public class ExperimentAll {
    private static String[] distributionEnergyPrefixs = { "Normal_distribution_energy/", "Uniform_distribution_energy/"};
    private static String[] remainingEnergyPrefixs = {"High_energy/", "Medium_energy/", "Low_energy/"};
    private static String[] distributionLocationPrefixs = {"uniform_distribution_location/", "normal_distribution_location/"};
    private static String[] scenariosIndexs = {"s1-", "s2-", "s3-"};
    private static String[] sizes = {"20", "30", "40", "70", "80", "90", "100"};
    private static String[] sensorLocationIndexs = {"-far", "-near"};

    private static int LOOP = 30;

    public static void main(String[] args){

    }

    private static void run(String dataFolder){
        File f = new File(dataFolder);
        for(File subFile : f.listFiles()){
            if(subFile.isFile()){
                System.out.println(subFile.getName());
            } else{
                Experiment.run();
            }
        }
    }

}
