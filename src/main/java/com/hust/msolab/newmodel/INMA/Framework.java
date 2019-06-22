package com.hust.msolab.newmodel.INMA;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.INMA.Device.MC;
import com.hust.msolab.newmodel.INMA.Device.Message;
import com.hust.msolab.newmodel.INMA.Device.Sensor;
import com.hust.msolab.newmodel.INMA.Device.ServicesStation;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Framework {

    public void run(String inputFilePath) throws IOException {
        INMAFileIO reader = new INMAFileIO();
        Sensor[] sensors = reader.readData(inputFilePath);
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
                        continue;
                    }
                } else{
                    int nodeCausesLeastDeaths = causeOfDeaths.entrySet().stream().min((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getKey();
                    Message lastestMessage = servicesStation.getLastestMessage(nodeCausesLeastDeaths);
                    if(mc.canReturnToSSAfterCharge(sensors[nodeCausesLeastDeaths])){
                        mc.schedule(sensors[nodeCausesLeastDeaths], time, lastestMessage.getTs());
                        sensors[nodeCausesLeastDeaths].setE(Factors.SENSOR_Emax);
                        mc.popFromRequestPool(nodeCausesLeastDeaths);
                        continue;
                    }
                }

                int nearestSensorId = mc.getNearestSensor();
                if(mc.canReturnToSSAfterCharge(sensors[nearestSensorId])){
                    Message lastestMessage = servicesStation.getLastestMessage(nearestSensorId);
                    mc.schedule(sensors[nearestSensorId], time, lastestMessage.getTs());
                    sensors[nearestSensorId].setE(Factors.SENSOR_Emax);
                    mc.popFromRequestPool(nearestSensorId);
                    continue;
                } else{
                    mc.replenish();
                }
            }
        }

        for(Sensor sensor : sensors){
            if(null != sensor){
                System.out.print(sensor.getId() + " ");
            }
        }

        System.out.println("\nDeaths: " + (Factors.NUM_OF_SENSORS - validNodes.size()));
    }
}
