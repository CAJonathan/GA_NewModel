package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.ParentsSelectionOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.util.List;
import java.util.Random;

public class MixedParentsSelection implements ParentsSelectionOperator {

    public List<Pair<Individual, Individual>> execute(int numOfPair, List<Individual> individuals){
        Random rand = new Random();
        if(rand.nextDouble() < Factors.GA_CHANGE_PARENT_SELECTION_OPERATOR_PROBABILITY1){
            return new TounamentSelection().execute(numOfPair, individuals);
        } else{
            return new RandomlyParentsSelection().execute(numOfPair, individuals);
        }
    }
}
