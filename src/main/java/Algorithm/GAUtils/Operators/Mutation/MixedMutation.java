package Algorithm.GAUtils.Operators.Mutation;

import Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import Utilities.Factors;

import java.util.ArrayList;
import java.util.Random;

public class MixedMutation implements MutationOperator {

    public ArrayList<Integer> execute(ArrayList<Integer> chromosome){
        Random rand = new Random();
        MutationOperator mutationOperator;
        if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY){
            if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY2){
                mutationOperator = new NormalMutation();
            } else{
                mutationOperator = new CimMutation();
            }
        } else{
            return chromosome;
        }

        return mutationOperator.execute(chromosome);
    }
}
