package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

public class ImplementScenario {

    public static void main(String[] args){
        Scenario scenario = new Scenario4();
        Properties properties = scenario.createProperties();
        scenario.run(properties);
    }
}
