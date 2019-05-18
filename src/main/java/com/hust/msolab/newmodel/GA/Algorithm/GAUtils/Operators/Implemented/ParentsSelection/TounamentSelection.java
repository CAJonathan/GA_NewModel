package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.ParentsSelectionOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TounamentSelection implements ParentsSelectionOperator {

    public List<Pair<Individual, Individual>> execute(int numOfPair, List<Individual> individuals){
        Random rand = new Random();
        List<Pair<Individual, Individual>> listOfParents = new ArrayList<>();
        for(int i = 0 ; i < numOfPair ; i ++){
            Integer[] indexOfSelectedIndividual = rand.ints(0, Factors.GA_POPULATION_SIZE)
                    .boxed()
                    .distinct()
                    .limit(Factors.GA_TOURNAMENT_SIZE)
                    .toArray(Integer[]::new);
            ArrayList<Individual> tounamentList = new ArrayList<>();
            for(Integer index : indexOfSelectedIndividual){
                tounamentList.add(individuals.get(index));
            }
            Utils.sort(tounamentList);
            listOfParents.add(new Pair(tounamentList.get(0), tounamentList.get(1)));
        }

        return listOfParents;
    }
}
