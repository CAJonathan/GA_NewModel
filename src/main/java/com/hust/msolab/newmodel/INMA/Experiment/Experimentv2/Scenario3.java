package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Framework;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;
import org.javatuples.Triplet;

import java.util.List;
import java.util.Map;

public class Scenario3 extends Scenario {

    public TriProperties createProperties(){
        TriProperties properties = new TriProperties();
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e4/n100-far-inmaresult.txt", 40000.0, 10502.81);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e6/n100-far-inmaresult.txt", 60000.0, 14488.48);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e8/n100-far-inmaresult.txt", 80000.0, 18445.67);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-far.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e10/n100-far-inmaresult.txt", 100000.0, 22477.31);

        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e4/n100-near-inmaresult.txt", 40000.0, 8936.91);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e6/n100-near-inmaresult.txt", 60000.0, 12952.19);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e8/n100-near-inmaresult.txt", 80000.0, 16939.45);
        properties.addProperty(Factors.INPUT_FOLDER + "/normal_distribution_location/n100-near.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e10/n100-near-inmaresult.txt", 100000.0, 20997.30);

        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e4/u100-inmaresult.txt", 40000.0, 12089.22);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e6/u100-inmaresult.txt", 60000.0, 15894.91);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e8/u100-inmaresult.txt", 80000.0, 20127.37);
        properties.addProperty(Factors.INPUT_FOLDER + "/uniform_distribution_location/u100.txt",
                Factors.OUTPUT_FOLDER + "/Scenario3/e10/u100-inmaresult.txt", 100000.0, 23766.79);

        return properties;
    }

    public void run(Properties properties){
        Map<String, List<Triplet<String, Double, Double>>> propMap = properties.getProperties();
        for(Map.Entry<String, List<Triplet<String, Double, Double>>> kv : propMap.entrySet()){
            String inputFilePath = kv.getKey();
            for(Triplet<String, Double, Double> tri : kv.getValue()){
                String outputFilePath = tri.getValue0();
                Factors.WCE_Emc = tri.getValue1();
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
