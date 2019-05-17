package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.util.List;

public interface ParentsSelectionOperator {

    List<Pair<Individual, Individual>> execute(int numOfPair, List<Individual> individuals);
}
