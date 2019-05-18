package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NormalMutation implements MutationOperator {
    public List<Integer> execute(List<Integer> chromosome){
        Random rand = new Random();
        int f = rand.nextInt(chromosome.size());
        int s = rand.nextInt(chromosome.size());

        Collections.swap(chromosome, f, s);

        return chromosome;
    }
}
