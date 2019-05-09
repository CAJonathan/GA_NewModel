package Algorithm;

import Utilities.Factors;
import Utilities.IOParser;

import java.io.IOException;

public class Algorithm {

    private Individual bestIndividual;

    public void solve() throws IOException {
        IOParser parser = new IOParser();
        String inputFilePath = Factors.PATH_TO_RESOURCE +
                                Factors.INPUT_FOLDER +
                                Factors.DISTRIBUTION_ENERGY_PREFIX +
                                Factors.REMAINING_ENERGY_PREFIX +
                                Factors.DISTRIBUTION_LOCATION_PREFIX +
                                Factors.INPUTFILE_NAME;
        Main.distances = parser.initDistanceMatrixWithPointsSetData(inputFilePath);

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
