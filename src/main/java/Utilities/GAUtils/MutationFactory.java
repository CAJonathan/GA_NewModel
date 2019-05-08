package Utilities.GAUtils;

/**
 * @author cajonathan
 * @param chromosome - individual's chromosome
 * @return Mutated chromosome
 */

import Utilities.Factors;
import Utilities.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class MutationFactory {

    public static ArrayList<Integer> mutate(ArrayList<Integer> chromosome){
        switch (Factors.GA_CHOSEN_MUTATION_FUNCTION){

            default:{
                return cimMutate(chromosome);
            }

            case 2:{
                return normalMutate(chromosome);
            }

            case 3:{
                return mixedMutate1(chromosome);
            }

            case 4:{
                return shufflenMutate(chromosome);
            }

            case 5:{
                return mixedMutate2(chromosome);
            }
        }
    }

    private static ArrayList<Integer> cimMutate(ArrayList<Integer> chromosome){
        int numOfGene = chromosome.size();
        Random rand = new Random();
        int wall = rand.nextInt(numOfGene);
        chromosome = Utils.Reverse(chromosome, 0, wall - 1);
        chromosome = Utils.Reverse(chromosome, wall, numOfGene - 1);

        return chromosome;
    }

    private static ArrayList<Integer> normalMutate(ArrayList<Integer> chromosome){
        Random rand = new Random();
        int f = rand.nextInt(chromosome.size());
        int s = rand.nextInt(chromosome.size());

        Collections.swap(chromosome, f, s);

        return chromosome;
    }

    private static ArrayList<Integer> mixedMutate1(ArrayList<Integer> chromosome){
        Random rand = new Random();
        if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY){
            if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY1){
                return cimMutate(chromosome);
            } else{
                return normalMutate(chromosome);
            }
        } else{
            return chromosome;
        }
    }

    private static ArrayList<Integer> shufflenMutate(ArrayList<Integer> chromosome){
        Collections.shuffle(chromosome);
        return chromosome;
    }

    private static ArrayList<Integer> mixedMutate2(ArrayList<Integer> chromosome){
        Random rand = new Random();
        if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY){
            if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY2){
                return shufflenMutate(chromosome);
            } else{
                return mixedMutate1(chromosome);
            }
        } else{
            return chromosome;
        }
    }

}
