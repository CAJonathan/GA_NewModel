package com.hust.msolab.newmodel.Algorithm;

import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.IOParser;

import java.io.IOException;

public class Algorithm {

    private Individual bestIndividual;
    private Individual worstIndividual;

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
