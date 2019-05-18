package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Crossover;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RmxCrossover implements CrossoverOperator {

    public Pair<Individual, Individual> execute(Individual indDad, Individual indMom) {
        Individual child1 = reproduct(indDad, indMom);
        Individual child2 = reproduct(indMom, indDad);

        return new Pair<>(child1, child2);
    }

    private Individual reproduct(Individual indDad, Individual indMom){
        Random rand = new Random();

        List<Integer> dadChromosome = indDad.getChromosome();
        List<Integer> momChromosome = indMom.getChromosome();

        boolean [] isInOffspringChromosome = new boolean[Factors.NUM_OF_SENSORS + 1];
        boolean [] isEmptyPosition = new boolean[Factors.NUM_OF_SENSORS];
        Arrays.fill(isInOffspringChromosome, false);
        Arrays.fill(isEmptyPosition, true);
        isInOffspringChromosome[0] = true;

        Integer[] childChromosomeTmp = new Integer[Factors.NUM_OF_SENSORS];

        int rmxLength = rand.nextInt(Factors.NUM_OF_SENSORS);
        int beginPosition = rand.nextInt(Factors.NUM_OF_SENSORS - rmxLength);
        int endPosition = beginPosition + rmxLength;

        for(int i = beginPosition ; i < endPosition ; i ++) {
            childChromosomeTmp[i] = dadChromosome.get(i);
            isEmptyPosition[i] = false;
            isInOffspringChromosome[dadChromosome.get(i)] = true;
        }

        for(int i = beginPosition ; i < endPosition ; i ++) {
            int gene = momChromosome.get(i);

            if(isInOffspringChromosome[gene]) {
                continue;
            } else {
                int freeIndex = i;
                while(!isEmptyPosition[freeIndex]) {
                    freeIndex = momChromosome.indexOf(dadChromosome.get(freeIndex));
                }

                childChromosomeTmp[freeIndex] = gene;
                isEmptyPosition[freeIndex] = false;
                isInOffspringChromosome[gene] = true;
            }
        }

        List<Integer> childChromosome = new ArrayList<>(momChromosome);
        for(int i = 0 ; i < Factors.NUM_OF_SENSORS ; i ++){
            if(!isEmptyPosition[i]){
                childChromosome.set(i, childChromosomeTmp[i]);
            }
        }

        return new Individual(childChromosome);
    }
}
