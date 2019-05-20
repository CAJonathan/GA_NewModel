package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Crossover;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionCrossover implements CrossoverOperator {

    @Override
    public Pair<Individual, Individual> execute(Individual indDad, Individual indMom) {
        Individual child1 = reproduct(indDad, indMom);
        Individual child2 = reproduct(indMom, indDad);

        return new Pair<>(child1, child2);
    }

    private Individual reproduct(Individual dad, Individual mom){
        Integer[] childChromosome = new Integer[Factors.NUM_OF_SENSORS];
        List<Integer> dadChromosome = dad.getChromosome();
        List<Integer> momChromosome = mom.getChromosome();

        for(int i = 0 ; i < Factors.NUM_OF_SENSORS ; i ++){
            int gene = momChromosome.get(i);
            childChromosome[i] = dadChromosome.get(gene - 1);
        }

        return new Individual(Arrays.asList(childChromosome));

    }
}
