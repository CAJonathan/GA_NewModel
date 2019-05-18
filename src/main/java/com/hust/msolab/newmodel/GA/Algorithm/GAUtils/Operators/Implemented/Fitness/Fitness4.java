package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Fitness;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;

public class Fitness4 implements FitnessFunction {

    public double execute(List<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();

        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);
            double distance = Factors.distances[previous][current];
            time += distance / Factors.WCE_V;

            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin - Factors.P.get(current) * time;
            if(remainingEnergy < 0){
                fitnessScore += 10000;
            } else{
                double sufferingTime = Factors.ALPHA * Factors.K * remainingEnergy / Factors.P.get(current);
                double moveTime = (1 - Factors.ALPHA) * distance / Factors.WCE_V;
                fitnessScore += sufferingTime + moveTime;
            }
        }

        return fitnessScore;
    }
}
