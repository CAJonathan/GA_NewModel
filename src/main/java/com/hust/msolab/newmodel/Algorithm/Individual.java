package com.hust.msolab.newmodel.Algorithm;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Factories.Factory;
import org.javatuples.Pair;
import java.util.*;

public class Individual {
    private ArrayList<Integer> chromosome;
    private double fitnessScore;

    public Individual(int numOfGene) {
        chromosome = new ArrayList<>();
        for(int i = 1 ; i <= numOfGene ; i ++){
            chromosome.add(i);
        }
        Collections.shuffle(chromosome);
        calculateFitnessScore();
    }
    public Individual(List<Integer> chromosome){
        this.chromosome = new ArrayList<>(chromosome);
        calculateFitnessScore();
    }

    public ArrayList<Integer> getChromosome() {
        return chromosome;
    }

    public void calculateFitnessScore() {
        Factory factory = new Factory();
        fitnessScore = factory.fitness(chromosome);
    }

    public double getFitnessScore() {
        return fitnessScore;
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
