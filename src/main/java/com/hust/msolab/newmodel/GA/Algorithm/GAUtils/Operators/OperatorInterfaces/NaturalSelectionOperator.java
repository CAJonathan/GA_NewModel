package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;

import java.util.List;

public interface NaturalSelectionOperator {

    List<Individual> execute(List<Individual> individuals);
}
