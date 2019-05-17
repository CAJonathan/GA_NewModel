package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

public interface CrossoverOperator {
    Pair<Individual, Individual> execute(Individual indDad, Individual indMom);
}
