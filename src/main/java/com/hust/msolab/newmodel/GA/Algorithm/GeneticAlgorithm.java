package com.hust.msolab.newmodel.GA.Algorithm;

import com.hust.msolab.newmodel.Algorithm;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

public class GeneticAlgorithm extends Algorithm {

    private Individual bestIndividual;
    private Individual worstIndividual;

    public void solve() {
        long startTime = System.nanoTime();
        Population population = new Population();
        for (int i = 0; i < Factors.GA_LOOP; i++) {
            population.crossover();
            population.mutate();
            population.sort();
            population.naturalSelection();
        }
        this.executionTime = System.nanoTime() - startTime;
        bestIndividual = population.bestSolution();
        worstIndividual = population.badSolution();
    }

    public Individual getSolution(){
        return bestIndividual;
    }

    public Individual getBadSolution(){return worstIndividual;}
}
