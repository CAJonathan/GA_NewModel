package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class TupProperties implements Properties {

    private Map<Pair<String, String>, Double> properties;

    public TupProperties(){
        properties = new HashMap<>();
    }

    public void addProperty(String inputFilePath, String outputFilePath, Double totalTime){
        properties.put(new Pair<>(inputFilePath, outputFilePath), totalTime);
    }

    public Map<Pair<String, String>, Double> getProperties() {
        return properties;
    }
}
