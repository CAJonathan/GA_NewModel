package Algorithm;

import java.io.IOException;

import Utilities.Factors;
import Utilities.IOParser;

public class Main {
    public static double [][] distances;

    public static void main(String[] args) throws IOException{

        IOParser parser = new IOParser();
        String inputFilePath = Factors.INPUTFILE_PATH_TO_DATA_FOLDER + Factors.INPUTFILE_REMAINING_ENERGY_PREFIX + Factors.INPUTFILE_DISTRIBUTED_PREFIX + Factors.INPUTFILE_NAME;
        distances = parser.initDistanceMatrixWithPointsSetData(inputFilePath);

        Population population = new Population();
        for (int i = 0; i < Factors.GA_LOOP; i++) {
            population.crossOver(Factors.GA_CROSSOVER_PROBABILITY);
            population.mutate(Factors.GA_MUTATION_PROBABILITY, Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY);
            population.sort();
            population.naturalSelection();
        }

        String outputFilePath = Factors.OUTPUT_PATH_TO_RESULT_FOLDER + Factors.OUTPUTFILE_NAME;
        parser.output(population.bestSolution(), outputFilePath);
    }
}
