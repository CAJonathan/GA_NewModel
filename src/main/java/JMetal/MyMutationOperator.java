package JMetal;

import Utilities.Factors;
import Utilities.Utils;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.solution.PermutationSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyMutationOperator implements MutationOperator<PermutationSolution> {
    @Override
    public PermutationSolution execute(PermutationSolution permutationSolution) {
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
