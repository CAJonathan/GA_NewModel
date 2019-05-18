package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import com.hust.msolab.newmodel.GA.Utilities.Utils;

import java.util.List;
import java.util.Random;

public class CimMutation implements MutationOperator {

    public List<Integer> execute(List<Integer> chromosome){
        int numOfGene = chromosome.size();
        Random rand = new Random();
        int wall = rand.nextInt(numOfGene);
        chromosome = Utils.Reverse(chromosome, 0, wall - 1);
        chromosome = Utils.Reverse(chromosome, wall, numOfGene - 1);

        return chromosome;
    }
}
