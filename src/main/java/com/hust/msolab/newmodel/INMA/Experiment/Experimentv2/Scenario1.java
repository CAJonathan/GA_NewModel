package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Framework;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;
import org.javatuples.Triplet;

import java.util.List;
import java.util.Map;

public class Scenario1 extends Scenario {

    public Properties createProperties(){
        Properties properties = new Properties();
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n20-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n20-far-inmaresult.txt", 5.0, 16751.12);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n30-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n30-far-inmaresult.txt", 5.0, 16851.25);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n40-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n40-far-inmaresult.txt", 5.0, 16977.80);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n70-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n70-far-inmaresult.txt", 5.0, 17656.52);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n80-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n80-far-inmaresult.txt", 5.0, 17679.55);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n90-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n90-far-inmaresult.txt", 5.0, 18236.19);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n100-far-inmaresult.txt", 5.0, 18446.82);

        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n20-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n20-near-inmaresult.txt", 5.0, 16348.04);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n30-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n30-near-inmaresult.txt", 5.0, 16456.64);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n40-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n40-near-inmaresult.txt", 5.0, 16505.72);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n70-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n70-near-inmaresult.txt", 5.0, 16731.52);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n80-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n80-near-inmaresult.txt", 5.0, 16844.69);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n90-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n90-near-inmaresult.txt", 5.0, 16870.26);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/normal_distribution_location/n100-near-inmaresult.txt", 5.0, 16922.19);

        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u20.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u20-inmaresult.txt", 5.0, 17093.78);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u30.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u30-inmaresult.txt", 5.0, 17376.46);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u40.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u40-inmaresult.txt", 5.0, 17562.12);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u70.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u70-inmaresult.txt", 5.0, 18924.36);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u80.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u80-inmaresult.txt", 5.0, 19273.02);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u90.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u90-inmaresult.txt", 5.0, 19552.56);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario1/uniform_distribution_location/u100-inmaresult.txt", 5.0, 20150.52);

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
