package Utilities.GAUtils;

import Utilities.Factors;
import Utilities.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MutationFactory {

    public static ArrayList<Integer> mutate(ArrayList<Integer> chromosome){
        switch (Factors.GA_CHOSEN_MUTATION_FUNCTION){
            case 1:{
                return cimMutate(chromosome);
            }

            case 2:{
                return normalMutate(chromosome);
            }

            default:{
                Random rand = new Random();
                if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY){
                    if(rand.nextDouble() < Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY){
                        return cimMutate(chromosome);
                    } else{
                        return normalMutate(chromosome);
                    }
                } else{
                    return chromosome;
                }
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

}
