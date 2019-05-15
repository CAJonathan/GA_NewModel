package Experiment;

import Algorithm.*;
import Utilities.Factors;
import Utilities.IOParser;
import Utilities.Utils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Experiment {

    public static int LOOP = 30;

    public static void main(String[] args){
//        Utils.createDataBin("ResultTest");
        run();
    }

    public static void run(){
        Factors factors = new Factors();
        Algorithm ag = new Algorithm(factors);
        try{
            List<Individual> individuals = new ArrayList<>();

            for(int i = 0 ; i < LOOP ; i ++){
                ag.solve();
                individuals.add(ag.getSolution());
            }

            double avgFitness = individuals.stream().mapToDouble(ind -> ind.getFitnessScore()).sum() / individuals.size();
            Collections.sort(individuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Individual bestInd = individuals.get(0);
            Individual worstInd = individuals.get(individuals.size() - 1);

            IOParser parser = new IOParser();
            String outputFilePath = factors.outputfilePath();
            parser.output(bestInd, avgFitness, worstInd.getFitnessScore(), outputFilePath);
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(factors.inputFilePath());
    }
}
