package com.hust.msolab.newmodel.INMA.Device;

import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicesStation {

    private List<Message>[] messagesQueues;
    double[] R;
    double ST;

    public ServicesStation(){
        R = new double[Factors.NUM_OF_SENSORS + 1];
        ST = 0.0;
        messagesQueues = new ArrayList[Factors.NUM_OF_SENSORS + 1];
        for(int i = 0 ; i <= Factors.NUM_OF_SENSORS ; i ++){
            messagesQueues[i] = new ArrayList<>();
        }
    }

    public void clearMessage(int sensorId){
        messagesQueues[sensorId].clear();
    }

    public void receiveMessage(Message message){
        messagesQueues[message.getId()].add(message);
    }

    public Map<Integer, Integer> calculateDepletions(double time, int mcLocation, List<Sensor> validNodes){
        Map<Integer, Integer> causeOfDeaths = new HashMap<>();
        Map<Integer, Double> latency = calculateLatency(time, validNodes);
        for(Sensor sensor : validNodes){
            int id = sensor.getId();
            Message lastestMessage = getLastestMessage(sensor);
            int death = 0;
            for(Sensor followingNode : validNodes){
                int followingId = followingNode.getId();
                double t_mc_i = Factors.distances[mcLocation][id];
                double t_i_j = Factors.distances[id][followingId] / Factors.WCE_V;
                double chargingTime = (Factors.SENSOR_Emax - (lastestMessage.getRE() - R[id] * (time - lastestMessage.getTs() + t_mc_i))) / Factors.WCE_CHARGING_RATE;
                double w = t_mc_i + chargingTime + t_i_j;

                death += w > latency.get(id) ? 1 : 0;
            }

            causeOfDeaths.put(id, death);
        }

        return causeOfDeaths;
    }

    private Map<Integer, Double> calculateLatency(double time, List<Sensor> validNodes){
        Map<Integer, Double> latencies = new HashMap<>();

        for(Sensor sensor : validNodes){
            int nodeId = sensor.getId();
            double P = sensor.getP();
            Message lastMessage = getLastestMessage(sensor);
            R[nodeId] = (R[nodeId]*ST + P*time) / (ST + time);
            double latency = (sensor.getE() - Factors.SENSOR_Emin) / R[nodeId] + lastMessage.getTs() - time;
            latencies.put(nodeId, latency);
        }
        ST += time;

        return latencies;
    }

    public int requestingSensorHavingMinChargingTime(MC mc, double time){
        List<Integer> requestPool = mc.requestPool();
        int minTchargeId = 0;
        double minTcharge = Double.MAX_VALUE;
        for(Integer id : requestPool){
            Message lastestMessage = getLastestMessage(id);
            double movingTime = Factors.distances[mc.getLocation()][id]/ Factors.WCE_V;
            double chargingTime = (Factors.SENSOR_Emax - (lastestMessage.getRE() - R[id] * (time - lastestMessage.getTs() + movingTime))) / Factors.WCE_CHARGING_RATE;
            if(chargingTime < minTcharge){
                minTcharge = chargingTime;
                minTchargeId = id;
            }
        }

        return minTchargeId;
    }

    public Message getLastestMessage(Sensor sensor){
        int id = sensor.getId();
        List<Message> queue = messagesQueues[id];
        return queue.get(queue.size() - 1);
    }

    public Message getLastestMessage(int id){
        List<Message> queue = messagesQueues[id];
        return queue.get(queue.size() - 1);
    }
}
