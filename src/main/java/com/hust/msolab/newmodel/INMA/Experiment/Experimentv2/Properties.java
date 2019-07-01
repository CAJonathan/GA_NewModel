package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import org.javatuples.Triplet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Properties {
    private Map<String, List<Triplet< String, Double, Double>>> properties;

    public Properties(){
        properties = new HashMap<>();
    }

    public void addProperty(String inputFilePath, String outputFilePath, Double mutable, Double totalTime){
        if(properties.containsKey(inputFilePath)){
            properties.get(inputFilePath).add(new Triplet<>(outputFilePath, mutable, totalTime));
        } else{
            List<Triplet< String, Double, Double>> triList = new LinkedList<>();
            triList.add(new Triplet<>(outputFilePath, mutable, totalTime));
            properties.put(inputFilePath, triList);
        }
    }

    public Map<String, List<Triplet<String, Double, Double>>> getProperties() {
        return properties;
    }
}
