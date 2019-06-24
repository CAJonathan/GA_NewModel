package com.hust.msolab.newmodel.INMA;

import com.hust.msolab.newmodel.Algorithm;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Device.MC;
import com.hust.msolab.newmodel.INMA.Device.Message;
import com.hust.msolab.newmodel.INMA.Device.Sensor;
import com.hust.msolab.newmodel.INMA.Device.ServicesStation;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Framework extends Algorithm {

    private Sensor[] sensors;
    private List<Integer> schedule;
    private int numOfDeaths;

    public Framework(String inputFilePath) throws IOException{
        this.executionTime = 0;
        schedule = new LinkedList<>();
        INMAFileIO reader = new INMAFileIO();
        sensors = reader.readData(inputFilePath);
    }

    public void solve() {
        MC mc = new MC(0);
        ServicesStation servicesStation = new ServicesStation();
        List<Sensor> validNodes = new ArrayList<>();

        double time = 0.0;
        while(time < Factors.DURING){
            time += Factors.TIME_INTERVAL;
            validNodes = new ArrayList<>();
            for(Sensor sensor : sensors){
                if(null != sensor){
                    sensor.moniterEnergy();
                    if(sensor.isValid()){
                        validNodes.add(sensor);
                        Message message = sensor.sendMessage(time);
                        if(message.getUrg()){
                            mc.pushToRequestPool(message.getId());
                        }
                        servicesStation.receiveMessage(message);
                    } else{
                        mc.popFromRequestPool(sensor.getId());
                        servicesStation.clearMessage(sensor.getId());
                    }
                }
            }

            long startTime = System.nanoTime();
            if(!validNodes.isEmpty() && !mc.requestPool().isEmpty() && !mc.act()){
                List<Integer> Z = new ArrayList<>();
                Map<Integer, Integer> causeOfDeaths = servicesStation.calculateDepletions(time, mc.getLocation(), validNodes);
                for(Map.Entry<Integer, Integer> deaths : causeOfDeaths.entrySet()){
                    if(deaths.getValue() == 0){
                        Z.add(deaths.getKey());
                    }
                }

                if(!Z.isEmpty()){
                    int nodeHavingMinTcharge = servicesStation.requestingSensorHavingMinChargingTime(mc, time);
                    Message lastestMessage = servicesStation.getLastestMessage(nodeHavingMinTcharge);
                    if(mc.canReturnToSSAfterCharge(sensors[nodeHavingMinTcharge])){
                        mc.schedule(sensors[nodeHavingMinTcharge], time, lastestMessage.getTs());
                        sensors[nodeHavingMinTcharge].setE(Factors.SENSOR_Emax);
                        mc.popFromRequestPool(nodeHavingMinTcharge);
                        schedule.add(nodeHavingMinTcharge);
                        continue;
                    }
                } else{
                    int nodeCausesLeastDeaths = causeOfDeaths.entrySet().stream().min((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getKey();
                    Message lastestMessage = servicesStation.getLastestMessage(nodeCausesLeastDeaths);
                    if(mc.canReturnToSSAfterCharge(sensors[nodeCausesLeastDeaths])){
                        mc.schedule(sensors[nodeCausesLeastDeaths], time, lastestMessage.getTs());
                        sensors[nodeCausesLeastDeaths].setE(Factors.SENSOR_Emax);
                        mc.popFromRequestPool(nodeCausesLeastDeaths);
                        schedule.add(nodeCausesLeastDeaths);
                        continue;
                    }
                }

                int nearestSensorId = mc.getNearestSensor();
                if(mc.canReturnToSSAfterCharge(sensors[nearestSensorId])){
                    Message lastestMessage = servicesStation.getLastestMessage(nearestSensorId);
                    mc.schedule(sensors[nearestSensorId], time, lastestMessage.getTs());
                    sensors[nearestSensorId].setE(Factors.SENSOR_Emax);
                    mc.popFromRequestPool(nearestSensorId);
                    schedule.add(nearestSensorId);
                } else{
                    mc.replenish();
                }
            }
            this.executionTime += System.nanoTime() - startTime;
        }

        this.numOfDeaths = Factors.NUM_OF_SENSORS - validNodes.size();
    }

    public List<Integer> getSchedule() {
        return schedule;
    }

    public int getNumOfDeaths() {
        return numOfDeaths;
    }
}
