package Algorithm.GAUtils.Operators.Mutation;

import Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class NormalMutation implements MutationOperator {
    public ArrayList<Integer> execute(ArrayList<Integer> chromosome){
        Random rand = new Random();
        int f = rand.nextInt(chromosome.size());
        int s = rand.nextInt(chromosome.size());

        Collections.swap(chromosome, f, s);

        return chromosome;
    }
}
