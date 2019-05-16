package Algorithm.GAUtils.Operators.Mutation;

import Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import Utilities.Utils;

import java.util.ArrayList;
import java.util.Random;

public class CimMutation implements MutationOperator {

    public ArrayList<Integer> execute(ArrayList<Integer> chromosome){
        int numOfGene = chromosome.size();
        Random rand = new Random();
        int wall = rand.nextInt(numOfGene);
        chromosome = Utils.Reverse(chromosome, 0, wall - 1);
        chromosome = Utils.Reverse(chromosome, wall, numOfGene - 1);

        return chromosome;
    }
}
