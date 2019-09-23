package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Framework;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;
import org.javatuples.Triplet;

import java.util.List;
import java.util.Map;

public class Scenario2 extends Scenario{

    public TriProperties createProperties(){
        TriProperties properties = new TriProperties();
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v2/n100-far-inmaresult.txt", 2.0, 21669.97);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v5/n100-far-inmaresult.txt", 5.0, 18320.02);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v7/n100-far-inmaresult.txt", 7.0, 17662.90);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v10/n100-far-inmaresult.txt", 10.0, 17205.68);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v15/n100-far-inmaresult.txt", 15.0, 16843.31);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v20/n100-far-inmaresult.txt", 20.0, 16619.96);

        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v2/n100-near-inmaresult.txt", 2.0, 18550.21);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v5/n100-near-inmaresult.txt", 5.0, 17052.90);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v7/n100-near-inmaresult.txt", 7.0, 16752.68);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v10/n100-near-inmaresult.txt", 10.0, 16331.89);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v15/n100-near-inmaresult.txt", 15.0, 16844.69);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v20/n100-near-inmaresult.txt", 20.0, 16248.63);

        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v2/u100-inmaresult.txt", 2.0, 25808.89);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v5/u100-inmaresult.txt", 5.0, 20080.89);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v7/u100-inmaresult.txt", 7.0, 18835.63);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v10/u100-inmaresult.txt", 10.0, 17879.29);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v15/u100-inmaresult.txt", 15.0, 17493.46);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario2/v20/u100-inmaresult.txt", 20.0, 16987.91);

        return properties;
    }

    public void run(Properties properties){
        Map<String, List<Triplet<String, Double, Double>>> propMap = properties.getProperties();
        for(Map.Entry<String, List<Triplet<String, Double, Double>>> kv : propMap.entrySet()){
            String inputFilePath = kv.getKey();
            for(Triplet<String, Double, Double> tri : kv.getValue()){
                String outputFilePath = tri.getValue0();
                Factors.WCE_V = tri.getValue1();
                Factors.DURING = tri.getValue2();
                try{
                    System.out.println(inputFilePath);
                    INMAFileIO fileIO = new INMAFileIO();
                    Framework framework = new Framework(inputFilePath);
                    framework.solve();
                    fileIO.output(framework.getSchedule(), framework.getNumOfDeaths(), framework.getExecutionTime(), outputFilePath);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
