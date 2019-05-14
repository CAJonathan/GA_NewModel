package Algorithm;

import Utilities.Factors;
import Utilities.IOParser;

import java.io.IOException;

public class Algorithm {

    private Individual bestIndividual;
    private Factors factors;

    public Algorithm(Factors factors){
        this.factors = factors;
    }

    public void solve() throws IOException {
        IOParser parser = new IOParser();
        Main.distances = parser.initDistanceMatrixWithPointsSetData();

        Population population = new Population();
        for (int i = 0; i < Factors.GA_LOOP; i++) {
            population.crossover();
            population.mutate();
            population.sort();
            population.naturalSelection();
        }

        bestIndividual = population.bestSolution();
    }

    public Individual getSolution(){
        return bestIndividual;
    }
}
