import Algorithm.*;
import Utilities.Factors;
import Utilities.IOParser;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Experiment {

    public static int LOOP = 30;

    public static void main(String[] args){
        Algorithm ag = new Algorithm();
        try{
            List<Individual> individuals = new ArrayList<>();

            for(int i = 0 ; i < LOOP ; i ++){
                ag.solve();
                individuals.add(ag.getSolution());
            }

            double avgFitness = individuals.stream().mapToDouble(ind -> ind.getFitnessScore()).sum() / individuals.size();
            Collections.sort(individuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Individual bestInd = individuals.get(0);

            IOParser parser = new IOParser();
            String outputFilePath = Factors.OUTPUT_PATH_TO_RESULT_FOLDER + Factors.OUTPUTFILE_NAME;
            parser.output(bestInd, avgFitness, outputFilePath);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
