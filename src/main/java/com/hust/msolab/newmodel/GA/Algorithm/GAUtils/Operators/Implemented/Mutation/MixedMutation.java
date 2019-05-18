package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;
import java.util.Random;

public class MixedMutation implements MutationOperator {

    public List<Integer> execute(List<Integer> chromosome){
        Random rand = new Random();
        MutationOperator mutationOperator;

        if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY2){
            mutationOperator = new NormalMutation();
        } else{
            mutationOperator = new CimMutation();
        }

        return mutationOperator.execute(chromosome);
    }
}
