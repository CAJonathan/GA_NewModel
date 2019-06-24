package com.hust.msolab.newmodel.INMA.Device;

import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.ArrayList;
import java.util.List;

public class MC {

    private double movingTime;
    private double chargingTime;
    private int location;
    private boolean isInSchedule;

    private double sysTime = 0.0;
    private double RE;

    private List<Integer> requestPool;

    public MC(int location){
        this.location = location;
        this.isInSchedule = false;
        this.RE = Factors.WCE_Emc;
        this.requestPool = new ArrayList<>();
    }

    public int getLocation() {
        return location;
    }

    public boolean act(){
        if(isInSchedule){
            sysTime += Factors.TIME_INTERVAL;
            if(sysTime > chargingTime + movingTime){
                isInSchedule = false;
                chargingTime = 0;
                movingTime = 0;
                sysTime = 0;
            }
        }
        return isInSchedule;
    }

    public void replenish(){
        this.movingTime = Factors.distances[this.location][0] / Factors.WCE_V;
        this.chargingTime = 0.0;
        location = 0;
        RE = Factors.WCE_Emc;
        this.isInSchedule = true;
    }

    public List<Integer> requestPool(){
        return requestPool;
    }

    public void pushToRequestPool(int sensorId){
        if(!requestPool.contains(new Integer(sensorId))){
            requestPool.add(sensorId);
        }
    }

    public void popFromRequestPool(int sensorId){
        requestPool.remove(new Integer(sensorId));
    }

    public boolean canReturnToSSAfterCharge(Sensor sensor){
        try{
            double arrivalTime = Factors.distances[location][sensor.getId()] / Factors.WCE_V;
            double eAfterCharge = RE - Factors.WCE_P_MOVE * Factors.distances[location][sensor.getId()] - (Factors.SENSOR_Emax - (sensor.getE() - arrivalTime * sensor.getP()));
            double eNeededToReturnToSS = Factors.WCE_P_MOVE * Factors.distances[sensor.getId()][0];

            return eAfterCharge >= eNeededToReturnToSS;
        }catch(Exception e){
            System.out.println(null == sensor);
        }

        return true;
    }

    public void schedule(Sensor sensor, double time, double lastTs){
        int nodeId = sensor.getId();
        this.movingTime = Factors.distances[location][nodeId] / Factors.WCE_V;
        double chargingEnergy = Factors.SENSOR_Emax - sensor.getE() + sensor.getP() * (time - lastTs + Factors.distances[location][nodeId]);
        this.chargingTime = chargingEnergy / Factors.WCE_CHARGING_RATE;
        this.location = nodeId;
        this.RE -= Factors.WCE_P_MOVE * Factors.distances[location][nodeId] - chargingEnergy;
        isInSchedule = true;
    }

    public int getNearestSensor(){
        int index = 0;
        double minDis = Double.MAX_VALUE;
        for(int i = 0 ; i < requestPool.size() ; i ++){
            int node = requestPool.get(i);
            if(Factors.distances[location][node] < minDis){
                index = i;
                minDis = Factors.distances[location][node];
            }
        }

        return index;
    }
}
