package com.hust.msolab.newmodel;

public abstract class Algorithm {
    protected double executionTime;

    public double getExecutionTime(){
        return executionTime / 1000000.0;
    }
    public abstract void solve();
}
