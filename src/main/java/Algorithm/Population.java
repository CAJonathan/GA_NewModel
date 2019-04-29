package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Utilities.Factors;
import org.javatuples.Pair;

public class Population {

    private ArrayList<Individual> individuals = new ArrayList<>();
    private int populationSize;

    public Population() {
        populationSize = Factors.GA_POPULATION_SIZE;
        for(int i = 0 ; i < populationSize ; i ++) {
            Individual item = new Individual(Factors.NUM_OF_SENSORS);
            individuals.add(item);
        }

        sort(individuals);
    }

    public void sort(){
        sort(individuals);
    }
    private void sort(ArrayList<Individual> indGroup) {
        Collections.sort(indGroup, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
    }

    public void crossOver(double probability) {
        List<Pair<Individual, Individual>> parentPairs = parentsSelection(populationSize/2);
        Random rand = new Random();
        for(Pair<Individual, Individual> parent : parentPairs) {
            if(rand.nextDouble() < probability){
                Individual dad = parent.getValue0();
                Individual mom = parent.getValue1();

                Pair<Individual, Individual> childs = dad.crossover(mom);

                individuals.add(childs.getValue0());
                individuals.add(childs.getValue1());
            }
        }
    }
    private List<Pair<Individual, Individual>> parentsSelection(int numOfPair){
        Random rand = new Random();
        List<Pair<Individual, Individual>> listOfParents = new ArrayList<>();
        for(int i = 0 ; i < numOfPair ; i ++){
            Integer[] indexOfSelectedIndividual = rand.ints(0, populationSize)
                    .boxed()
                    .distinct()
                    .limit(Factors.GA_TOURNAMENT_SIZE)
                    .toArray(Integer[]::new);
            ArrayList<Individual> tounamentList = new ArrayList<>();
            for(Integer index : indexOfSelectedIndividual){
                tounamentList.add(individuals.get(index));
            }
            sort(tounamentList);
            listOfParents.add(new Pair(tounamentList.get(0), tounamentList.get(1)));
        }

        return listOfParents;
    }

    public void mutate(double probability, double changeMutationOperator) {
        Random rand = new Random();
        for(int i = 0 ; i < individuals.size() ; i ++) {
            if(rand.nextDouble() < probability){
                if(rand.nextDouble() < changeMutationOperator){
                    individuals.get(i).cimMutate();
                } else{
                    individuals.get(i).normalMutate();
                }
            }
        }
    }

    public void naturalSelection() {
        int len = populationSize;
        while(individuals.size() > len) {
            individuals.remove(individuals.size() - 1);
        }
    }

    public Individual bestSolution(){
        return individuals.get(0);
    }

    public ArrayList<Individual> getIndividuals(){
        return individuals;
    }
}
