package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.NaturalSelection;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import com.hust.msolab.newmodel.Algorithm.Individual;
import com.hust.msolab.newmodel.Utilities.Factors;

import java.util.ArrayList;

public class NormalNaturalSelection implements NaturalSelectionOperator {



    public ArrayList<Individual> execute(ArrayList<Individual> individuals){
        while(individuals.size() > Factors.GA_POPULATION_SIZE) {
            individuals.remove(individuals.size() - 1);
        }

        return individuals;
    }
}
