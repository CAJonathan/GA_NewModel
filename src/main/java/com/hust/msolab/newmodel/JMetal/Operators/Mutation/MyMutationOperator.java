package com.hust.msolab.newmodel.JMetal.Operators.Mutation;

import com.hust.msolab.newmodel.JMetal.MySolution;
import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.Utils;
import org.uma.jmetal.operator.MutationOperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyMutationOperator implements MutationOperator<MySolution> {
    @Override
    public MySolution execute(MySolution permutationSolution) {
        ArrayList<Integer> chromosome = new ArrayList<>();
        for(int i = 0 ; i < permutationSolution.getNumberOfVariables() ; i ++){
            chromosome.add((int)permutationSolution.getVariableValue(i));
        }
        Random rand = new Random();
        if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY){
            if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY1){
                int numOfGene = chromosome.size();
                int wall = rand.nextInt(numOfGene);
                chromosome = Utils.Reverse(chromosome, 0, wall - 1);
                chromosome = Utils.Reverse(chromosome, wall, numOfGene - 1);
            } else{
                int f = rand.nextInt(chromosome.size());
                int s = rand.nextInt(chromosome.size());

                Collections.swap(chromosome, f, s);
            }
        } else{
            return permutationSolution;
        }

        for(int i = 0 ; i < permutationSolution.getNumberOfVariables() ; i ++){
            permutationSolution.setVariableValue(i, chromosome.get(i));
        }

        return permutationSolution;
    }
}
