package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Fitness;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;
import java.util.stream.DoubleStream;

public class Fitness8 implements FitnessFunction {

    public double execute(List<Integer> chromosome){
        int numOfGenes = chromosome.size();

        double[] w = new double[numOfGenes];

        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);
            double distance = Factors.distances[previous][current];
            time += distance / Factors.WCE_V;

            w[i] = Factors.P.get(current) * time / (Factors.REMAINING_ENERGIES.get(current));
        }

        double F1 = DoubleStream.of(w).sum();
        double F2 = 0.0;
        double avgF = F1 / numOfGenes;
        for(double w_i : w){
            F2 += Math.abs(w_i - avgF);
        }

        return Factors.ALPHA * F1 + (1 - Factors.ALPHA) * F2;
    }
}
