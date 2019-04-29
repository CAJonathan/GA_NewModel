package Algorithm;

import Utilities.Factors;
import Utilities.GAUtils.CrossoverFactory;
import Utilities.GAUtils.FitnessFactory;
import Utilities.GAUtils.MutationFactory;
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

    public void normalMutate() {
        Random rand = new Random();
        int f = rand.nextInt(chromosome.size());
        int s = rand.nextInt(chromosome.size());

        Collections.swap(chromosome, f, s);
    }
    public void cimMutate() {
        int numOfGene = chromosome.size();
        Random rand = new Random();
        int wall = rand.nextInt(numOfGene);
        ReverseGeneSegment(0, wall - 1);
        ReverseGeneSegment(wall, numOfGene - 1);
    }
    private void ReverseGeneSegment( int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            Collections.swap(chromosome, i, j);
            i ++;
            j --;
        }
    }

    public Pair<Individual, Individual> crossover(Individual partner){
        Individual dad = this;
        return CrossoverFactory.crossover(this, partner);
    }

}
