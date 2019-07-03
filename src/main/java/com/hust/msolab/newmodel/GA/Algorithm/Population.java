package com.hust.msolab.newmodel.GA.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Factories.Factory;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import org.javatuples.Pair;

/**
 * Class thuộc thuật toán GA, đại diện cho một quần thể (chứa nhiều cá thể).
 *
 * @author sondn 30/04/2019
 */

public class Population {

    private List<Individual> individuals;

    public Population() {
        individuals = new ArrayList<>();
        for(int i = 0; i < Factors.GA_POPULATION_SIZE ; i ++) {
            Individual item = new Individual(Factors.NUM_OF_SENSORS);
            individuals.add(item);
        }

        individuals = Utils.sort(individuals);
    }

    public void sort(){
        individuals = Utils.sort(individuals);
    }

    public void crossover() {
        Factory factory = new Factory();
        List<Pair<Individual, Individual>> parentPairs = factory.parentsSelection(Factors.GA_PARENTS_PAIR_SIZE, individuals);
        Random rand = new Random();
        for(Pair<Individual, Individual> parent : parentPairs) {
            if(rand.nextDouble() < Factors.GA_CROSSOVER_PROBABILITY){
                Individual dad = parent.getValue0();
                Individual mom = parent.getValue1();

                Pair<Individual, Individual> childs = dad.crossover(mom);

                individuals.add(childs.getValue0());
                individuals.add(childs.getValue1());
            }
        }
    }

    public void mutate() {
        Random rand = new Random();
        for(Individual individual : individuals) {
            if(rand.nextDouble() < Factors.GA_MUTATION_PROBABILITY) {
                individual.mutate();
            }
        }
    }

    public void naturalSelection() {
        Factory factory = new Factory();
        individuals = factory.naturalSelection(individuals);
    }

    public Individual bestSolution(){
        return individuals.get(0);
    }

    public Individual badSolution(){
        return individuals.get(individuals.size() - 1);
    }
}
