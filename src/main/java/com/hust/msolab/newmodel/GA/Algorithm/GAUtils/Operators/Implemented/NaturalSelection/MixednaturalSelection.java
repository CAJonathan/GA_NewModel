package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.NaturalSelection;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;

public class MixednaturalSelection implements NaturalSelectionOperator {

    @Override
    public List<Individual> execute(List<Individual> individuals) {
        Individual bestInd = individuals.get(0);
        Individual worstInd = individuals.get(individuals.size() - 1);

        double centerFitness = (bestInd.getFitnessScore() + worstInd.getFitnessScore()) / 2;
        double avgFitness = individuals.stream().mapToDouble(ind -> ind.getFitnessScore()).sum() / individuals.size();

        if(Math.abs(centerFitness - avgFitness) < avgFitness * Factors.GA_DIVERSITY_THRESHOLD){
            return new NormalNaturalSelection().execute(individuals);
        } else{
            return new RouletteWheelSelection().execute(individuals);
        }
    }
}
