package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Fitness;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.Utilities.Factors;

import java.util.ArrayList;

public class Fitness3 implements FitnessFunction {

    public double execute(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);

            double entryRemainingEnergy = Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin;
            double sufferingTime = Factors.ALPHA * Factors.K * entryRemainingEnergy / Factors.P.get(current);
            double moveTime = (1 - Factors.ALPHA) * Factors.distances[previous][current] / Factors.WCE_V;
            double priority = i * 1.0  / numOfGenes;
            fitnessScore += priority * sufferingTime + moveTime;

        }

        return fitnessScore;
    }
}
