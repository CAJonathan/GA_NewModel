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
            List<Individual> goodIndividuals = new ArrayList<>();
            List<Individual> badIndividuals = new ArrayList<>();

            for(int i = 0 ; i < LOOP ; i ++){
                ag.solve();
                goodIndividuals.add(ag.getSolution());
                badIndividuals.add(ag.getBadSolution());
            }

            double avgFitness = goodIndividuals.stream().mapToDouble(ind -> ind.getFitnessScore()).sum() / goodIndividuals.size();
            Collections.sort(goodIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Collections.sort(badIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Individual bestInd = goodIndividuals.get(0);
            Individual badInd = badIndividuals.get(badIndividuals.size() - 1);

            IOParser parser = new IOParser();
            String outputFilePath = factors.outputfilePath();
            parser.output(bestInd, avgFitness, badInd, outputFilePath);
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(factors.inputFilePath());
    }
}
