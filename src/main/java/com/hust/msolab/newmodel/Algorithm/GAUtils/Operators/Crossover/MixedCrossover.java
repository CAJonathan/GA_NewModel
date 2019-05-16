package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Crossover;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import com.hust.msolab.newmodel.Algorithm.Individual;
import com.hust.msolab.newmodel.Utilities.Factors;
import org.javatuples.Pair;

import java.util.Random;

public class MixedCrossover implements CrossoverOperator {

    public Pair<Individual, Individual> execute(Individual indDad, Individual indMom){
        Random rand = new Random();
        CrossoverOperator crossoverOperator;
        if(rand.nextDouble() < Factors.GA_CHANGE_CROSSOVER_OPERATION_PROBABILITY1){
            crossoverOperator = new CircleCrossover();
        } else{
            crossoverOperator = new SimpleCrossover();
        }

        return crossoverOperator.execute(indDad, indMom);
    }
}
