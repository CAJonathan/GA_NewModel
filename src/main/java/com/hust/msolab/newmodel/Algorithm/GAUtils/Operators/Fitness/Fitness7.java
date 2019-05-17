package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Fitness;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.Utilities.Factors;

import java.util.ArrayList;

public class Fitness7 implements FitnessFunction {

    public double execute(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();

        double totalDistance = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);
            totalDistance += Factors.distances[previous][current];
        }

        double tMove = (totalDistance + Factors.distances[chromosome.get(numOfGenes - 1)][0]) / Factors.WCE_V;
        double eMove =  Factors.WCE_P_MOVE * tMove;
        double eCharge = Factors.WCE_Emc - eMove;
        double tCharge = eCharge / Factors.WCE_U;

        double T = tMove + tCharge;

        double[] tChargeMinForEachSensor = new double[numOfGenes + 1];
        tChargeMinForEachSensor[0] = 0.0;
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

            fitnessScore += Factors.P.get(current) * time / (Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin);

            time += tChargeMinForEachSensor[current];
        }

        return fitnessScore;
    }
}
