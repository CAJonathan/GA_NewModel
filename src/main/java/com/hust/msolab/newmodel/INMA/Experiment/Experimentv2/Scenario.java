package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

public abstract class Scenario {

    public abstract Properties createProperties();
    public abstract void run(Properties properties);
}
