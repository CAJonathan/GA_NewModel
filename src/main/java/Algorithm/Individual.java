package Algorithm;

import Algorithm.GAUtils.CrossoverFactory;
import Algorithm.GAUtils.FitnessFactory;
import Algorithm.GAUtils.MutationFactory;
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
        fitnessScore = FitnessFactory.fitness(chromosome);
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public void mutate(){
        chromosome = MutationFactory.mutate(chromosome);
    }

    public Pair<Individual, Individual> crossover(Individual partner){
        return CrossoverFactory.crossover(this, partner);
    }

}
