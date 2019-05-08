package Utilities.GAUtils;

/**
 * @author cajonathan
 * @param chromosomes - one belongs to dad, the other belongs to mom
 * @return Two chromosomes represent offspring
 */

import Algorithm.Individual;
import Utilities.Factors;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CrossoverFactory {

    public static Pair<Individual, Individual> crossover(Individual indDad, Individual indMom){
        switch (Factors.GA_CHOSEN_CROSSOVER_FUNCTION){
            default: {
                return circleCrossover(indDad, indMom);
            }

            case 2:{
                return simpleCrossover(indDad, indMom);
            }

            case 3:{
                return mixedCrossover1(indDad, indMom);
            }
        }
    }

    private static Pair<Individual, Individual> circleCrossover(Individual indDad, Individual indMom){
        ArrayList<Integer> dad = indDad.getChromosome();
        ArrayList<Integer> mom = indMom.getChromosome();
        int numOfGene = dad.size();
        Integer[] child1 = new Integer[numOfGene];
        Integer[] child2 = new Integer[numOfGene];

        boolean[] isInCircle = new boolean[numOfGene];
        Arrays.fill(isInCircle, false);
        int circleIndex = 0;
        int circleNumber = 0;
        while(circleIndex < numOfGene ){
            while(circleIndex < numOfGene && isInCircle[circleIndex]){
                circleIndex ++;
            }
            if(circleIndex >= numOfGene) break;
            circleNumber ++;

            int begin = dad.get(circleIndex);
            int currentIndex = circleIndex;
            int check;

            do{
                check = mom.get(currentIndex);
                child1[currentIndex] = circleNumber % 2 == 1 ? dad.get(currentIndex) : check;
                child2[currentIndex] = circleNumber % 2 == 1 ? check : dad.get(currentIndex);
                isInCircle[currentIndex] = true;
                currentIndex = dad.indexOf(check);
            }while(check != begin);
        }
        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
    }

    private static Pair<Individual, Individual> simpleCrossover(Individual indDad, Individual indMom){
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
            for(int j = 0 ; j < numOfGene ; j ++){
                int gene1 = mom.get(j);
                if(!visited1[gene1]){
                    child1[i] = gene1;
                    visited1[gene1] = true;
                    break;
                }
            }

            for(int j = 0 ; j < numOfGene ; j ++){
                int gene2 = dad.get(j);
                if(!visited2[gene2]){
                    child2[i] = gene2;
                    visited2[gene2] = true;
                    break;
                }
            }
        }

        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
    }

    private static Pair<Individual, Individual> mixedCrossover1(Individual indDad, Individual indMom){
        Random rand = new Random();
        if(rand.nextDouble() < Factors.GA_CHANGE_CROSSOVER_OPERATION_PROBABILITY1){
            return circleCrossover(indDad, indMom);
        } else{
            return simpleCrossover(indDad, indMom);
        }
    }
}
