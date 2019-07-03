package com.hust.msolab.newmodel.INMA.Device;

/**
 * Class đại diện cho Message được gửi đi từ các sensor trong mạng cảm biến
 *
 * @author sondn on 05/06/2019
 */

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
