package com.hust.msolab.newmodel.INMA.Device;

import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.Random;

/**
 * Class đại diện cho sensor trong mạng cảm biến dùng trong thuật toán IMNA
 *
 * @author sondn on 05/06/2019
 */

public class Sensor {

    private int id;
    private double e;
    private double p;

    public Sensor(int id, double e){
        this.id = id;
        this.e = e;
        this.p = new Random().nextDouble() * 0.5;
    }

    public int getId() {
        return id;
    }

    public double getP() {
        return p;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public void moniterEnergy(){
        p = Math.pow(new Random().nextDouble(), 2);
        e -= p * Factors.TIME_INTERVAL;
    }

    public Message sendMessage(double timestamp){
        return new Message(id, e, timestamp, e < Factors.SENSOR_E_THRES);
    }

    public boolean isValid(){
        return e > Factors.SENSOR_Emin;
    }
}
