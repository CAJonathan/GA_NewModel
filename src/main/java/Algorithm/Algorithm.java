package Algorithm;

import Utilities.Factors;
import Utilities.IOParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private Individual bestIndividual;
    private Individual worstIndividual;
    private Factors factors;

    public Algorithm(Factors factors){
        this.factors = factors;
    }

    public void solve() throws IOException {
        IOParser parser = new IOParser();
        parser.initDistanceMatrixWithPointsSetData();

        Population population = new Population();
        for (int i = 0; i < Factors.GA_LOOP; i++) {
            population.crossover();
            population.mutate();
            population.sort();
            population.naturalSelection();
        }

        bestIndividual = population.bestSolution();
        worstIndividual = population.badSolution();
    }

    public Individual getSolution(){
        return bestIndividual;
    }

    public Individual getBadSolution(){return worstIndividual;}
}
