import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.javatuples.Pair;

public class Population {

    private ArrayList<Individual> individuals = new ArrayList<>();
    private int populationSize;
    private static final int tounamentSize = 5;

    public Population(int N, int numOfGenes) {
        populationSize = N;
        for(int i = 0 ; i < populationSize ; i ++) {
            Individual item = new Individual(numOfGenes);
            individuals.add(item);
        }

        sort();
    }

    public void sort() {
        sort(individuals);
    }

    private void sort(ArrayList<Individual> indGroup) {
        Collections.sort(indGroup, (i1, i2) ->  Double.compare( i2.getFitnessScore(), i1.getFitnessScore()));
    }

    public void crossOver(double probability, double changeCrossoverOperator) {
        List<Pair<Individual, Individual>> parentPairs = parentsSelection(populationSize/2);
        Random rand = new Random();
        for(Pair<Individual, Individual> parent : parentPairs) {
            if(rand.nextDouble() < probability){
//                if(rand.nextDouble() < changeCrossoverOperator){
//                    Individual dad = parent.getValue0();
//                    Individual mom = parent.getValue1();
//
//                    Individual child1 = dad.rmxReproduct(mom);
//                    Individual child2 = mom.rmxReproduct(dad);
//
//                    individuals.add(child1);
//                    individuals.add(child2);
//                } else{
                    Individual dad = parent.getValue0();
                    Individual mom = parent.getValue1();

                    Pair<Individual, Individual> childs = dad.circleCrossover(mom);

                    individuals.add(childs.getValue0());
                    individuals.add(childs.getValue1());
//                }
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
                    .limit(tounamentSize)
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

    public double bestSolution(){
        return individuals.get(0).getFitnessScore();
    }

    public void Output() {
        System.out.print("Best solution: ");
        System.out.println("   --   " + individuals.get(0).getFitnessScore());
    }

    public Individual bestIndividual(){
        return individuals.get(0);
    }


    public ArrayList<Individual> getIndividuals(){
        return individuals;
    }
}
