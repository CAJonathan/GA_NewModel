package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Fitness;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;

public class Fitness6 implements FitnessFunction {

    public double execute(List<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();

        double totalDistance = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);
            totalDistance += Factors.distances[previous][current];
        }

        double tMove = (totalDistance + Factors.distances[chromosome.get(numOfGenes - 1)][0]) / Factors.WCE_V;
        double eMove =  Factors.WCE_P_MOVE * tMove * Factors.WCE_V;
        double eCharge = Factors.WCE_Emc - eMove;
        double tCharge = eCharge / Factors.WCE_U;

        double T = tMove + tCharge;

        double[] tChargeMinForEachSensor = new double[numOfGenes];
        for(int i = 0 ; i < numOfGenes ; i ++){
            int current = chromosome.get(i);
            double tChargeTmp = (T*Factors.P.get(current) - Factors.REMAINING_ENERGIES.get(current) + Factors.SENSOR_Emin) / (Factors.WCE_U - Factors.P.get(current));
            tChargeMinForEachSensor[i] = tChargeTmp < 0 ? 0 : tChargeTmp;
        }

        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);

            double distance = Factors.distances[previous][current];
            time += distance / Factors.WCE_V;

            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current)- Factors.P.get(current) * time;
            if(remainingEnergy < Factors.SENSOR_Emin){
                if(i > 0){
                    int idx = 0;
                    double max = 0.0;
                    for(int j = 0 ; j < i ; j ++){
                        if(tChargeMinForEachSensor[j] > max){
                            max = tChargeMinForEachSensor[j];
                            idx = j;
                        }
                    }

                    if(max > tChargeMinForEachSensor[i]){
                        double timeTmp = time - max;
                        double remainingEnergyTmp = Factors.REMAINING_ENERGIES.get(current) - Factors.P.get(current) * timeTmp;
                        if(remainingEnergyTmp >= Factors.SENSOR_Emin){
                            time = time - max + tChargeMinForEachSensor[i];
                            tChargeMinForEachSensor[idx] = 0;
                        }
                    }
                }
                fitnessScore ++;
            } else{
                time += tChargeMinForEachSensor[i];
            }
        }

        return fitnessScore;
    }
}
