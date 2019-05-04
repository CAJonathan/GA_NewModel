package Algorithm;

import Utilities.Factors;
import Utilities.IOParser;

import java.io.IOException;

public class Algorithm {

    private Individual bestIndividual;

    public void solve() throws IOException {
        IOParser parser = new IOParser();
        String inputFilePath = Factors.INPUTFILE_PATH_TO_DATA_FOLDER + Factors.INPUTFILE_REMAINING_ENERGY_PREFIX + Factors.INPUTFILE_DISTRIBUTED_PREFIX + Factors.INPUTFILE_NAME;
        Main.distances = parser.initDistanceMatrixWithPointsSetData(inputFilePath);

        Population population = new Population();
        for (int i = 0; i < Factors.GA_LOOP; i++) {
            population.crossOver(Factors.GA_CROSSOVER_PROBABILITY);
            population.mutate(Factors.GA_MUTATION_PROBABILITY, Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY);
            population.sort();
            population.naturalSelection();
        }

        bestIndividual = population.bestSolution();
    }

    public Individual getSolution(){
        return bestIndividual;
    }
}
