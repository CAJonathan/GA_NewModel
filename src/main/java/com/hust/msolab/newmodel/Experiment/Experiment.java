package com.hust.msolab.newmodel.Experiment;

import com.hust.msolab.newmodel.Algorithm.*;
import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.IOParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Experiment {

    public static int LOOP = 30;

    public static void main(String[] args){
        run();
    }

    public static void run(){
        Algorithm ag = new Algorithm();
        try{
            List<Individual> goodIndividuals = new ArrayList<>();
            List<Individual> badIndividuals = new ArrayList<>();

            for(int i = 0 ; i < LOOP ; i ++){
                ag.solve();
                goodIndividuals.add(ag.getSolution());
                badIndividuals.add(ag.getBadSolution());
            }

            Collections.sort(goodIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Collections.sort(badIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Individual bestInd = goodIndividuals.get(0);
            Individual worstInd = badIndividuals.get(badIndividuals.size() - 1);

            IOParser parser = new IOParser();
            parser.output(bestInd, worstInd);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
