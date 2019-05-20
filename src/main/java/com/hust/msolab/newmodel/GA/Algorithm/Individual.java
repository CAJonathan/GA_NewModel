package com.hust.msolab.newmodel.GA.Algorithm;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Factories.Factory;
import org.javatuples.Pair;
import java.util.*;

public class Individual {
    private List<Integer> chromosome;
    private double fitnessScore;

    public Individual(int numOfGene) {
        Integer[] sensors = new Integer[numOfGene];
        Arrays.setAll(sensors, index -> index + 1);
        chromosome = new ArrayList<>(Arrays.asList(sensors));
        Collections.shuffle(chromosome);
        calculateFitnessScore();
    }
    public Individual(List<Integer> chromosome){
        this.chromosome = new ArrayList<>(chromosome);
        calculateFitnessScore();
    }

    public List<Integer> getChromosome() {
        return chromosome;
    }
    public double getFitnessScore() {
        return fitnessScore;
    }

    public void calculateFitnessScore() {
        Factory factory = new Factory();
        fitnessScore = factory.fitness(chromosome);
    }

    public void mutate(){
        Factory factory = new Factory();
        chromosome = factory.mutation(chromosome);
        calculateFitnessScore();
    }

    public Pair<Individual, Individual> crossover(Individual partner){
        Factory factory = new Factory();
        return factory.crossover(this, partner);
    }

}
