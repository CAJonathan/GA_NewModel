package com.hust.msolab.newmodel.INMA.Device;

public class Message {

    private int id;
    private double RE;
    private double ts;
    private boolean urg;

    public Message(int id, double RE, double ts, boolean urg){
        this.id = id;
        this.RE = RE;
        this.ts = ts;
        this.urg = urg;
    }

    public int getId() {
        return id;
    }

    public double getRE() {
        return RE;
    }

    public double getTs() {
        return ts;
    }

    public boolean getUrg() {
        return urg;
    }
}
