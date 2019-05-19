package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.ParentsSelectionOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.util.*;

public class RandomlyParentsSelection implements ParentsSelectionOperator {

    public List<Pair<Individual, Individual>> execute(int numOfPair, List<Individual> individuals){
        Random rand = new Random();
        List<Pair<Individual, Individual>> listOfParents = new ArrayList<>();

        Integer[] indexArr = new Integer[individuals.size()];
        Arrays.setAll(indexArr, (index) -> index);
        List<Integer> indexs = new LinkedList<>(Arrays.asList(indexArr));

        for(int i = 0 ; i < numOfPair ; i ++){
            int dadIndex = rand.nextInt(indexs.size());
            indexs.remove(dadIndex);
            int momIndex = rand.nextInt(indexs.size());
            indexs.remove(momIndex);

            listOfParents.add(new Pair<>(individuals.get(dadIndex), individuals.get(momIndex)));
        }

        return listOfParents;
    }
}
