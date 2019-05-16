package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Fitness;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.Utilities.Factors;

import java.util.ArrayList;

public class Fitness2 implements FitnessFunction {

    public double execute(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);

            double sufferingTime = Factors.ALPHA * Factors.K * (Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin) / Factors.P.get(current);
            double moveTime = (1 - Factors.ALPHA) * Factors.distances[previous][current] / Factors.WCE_V;
            fitnessScore += sufferingTime + moveTime;

        }

        return fitnessScore;
    }
}
