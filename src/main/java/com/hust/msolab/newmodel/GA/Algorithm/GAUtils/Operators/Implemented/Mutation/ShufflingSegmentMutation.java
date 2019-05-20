package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShufflingSegmentMutation implements MutationOperator {

    @Override
    public List<Integer> execute(List<Integer> chromosome) {
        Random rand = new Random();
        List<Integer> newChromosome = new ArrayList<>();

        int cuttingPoint = rand.nextInt(Factors.NUM_OF_SENSORS);
        newChromosome.addAll(chromosome.subList(cuttingPoint, Factors.NUM_OF_SENSORS));
        newChromosome.addAll(chromosome.subList(0, cuttingPoint));
        return newChromosome;
    }
}
