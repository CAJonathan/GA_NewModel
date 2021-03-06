package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Fitness;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;

public class Fitness1 implements FitnessFunction {

    public double execute(List<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            fitnessScore += Factors.ALPHA / (Factors.REMAINING_ENERGIES.get(current)) + (1 - Factors.ALPHA) * Factors.K / (Factors.distances[previous][current]);
        }

        return fitnessScore;
    }
}
