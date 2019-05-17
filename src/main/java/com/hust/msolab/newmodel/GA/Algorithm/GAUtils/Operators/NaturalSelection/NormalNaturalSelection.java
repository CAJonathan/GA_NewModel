package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.NaturalSelection;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.util.List;

public class NormalNaturalSelection implements NaturalSelectionOperator {

    public List<Individual> execute(List<Individual> individuals){
        while(individuals.size() > Factors.GA_POPULATION_SIZE) {
            individuals.remove(individuals.size() - 1);
        }

        return individuals;
    }
}
