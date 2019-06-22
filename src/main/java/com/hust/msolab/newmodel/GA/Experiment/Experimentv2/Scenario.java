package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import java.io.IOException;

public abstract class Scenario {
    abstract void initFixedValues();
    abstract void run(String dataFolder) throws IOException;
}
