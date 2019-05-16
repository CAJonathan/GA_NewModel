package Algorithm.GAUtils.Operators.Crossover;

import Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import Algorithm.Individual;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SimpleCrossover implements CrossoverOperator {

    public Pair<Individual, Individual> execute(Individual indDad, Individual indMom){
        ArrayList<Integer> dad = indDad.getChromosome();
        ArrayList<Integer> mom = indMom.getChromosome();
        int numOfGene = dad.size();

        Integer[] child1 = new Integer[numOfGene];
        Integer[] child2 = new Integer[numOfGene];

        int cuttingPoint = (new Random()).nextInt(numOfGene - 2) + 1;
        boolean[] visited1 = new boolean[numOfGene + 1];
        boolean[] visited2 = new boolean[numOfGene + 1];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        for(int i = 0 ; i < cuttingPoint ; i ++){
            int gene1 = dad.get(i);
            int gene2 = mom.get(i);
            child1[i] = gene1;
            child2[i] = gene2;
            visited1[gene1] = true;
            visited2[gene2] = true;
        }

        for(int i = cuttingPoint ; i < numOfGene ; i ++){
            for(Integer gene1 : mom){
                if(!visited1[gene1]){
                    child1[i] = gene1;
                    visited1[gene1] = true;
                    break;
                }
            }

            for(Integer gene2 : dad){
                if(!visited2[gene2]){
                    child2[i] = gene2;
                    visited2[gene2] = true;
                    break;
                }
            }
        }

        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
    }
}
