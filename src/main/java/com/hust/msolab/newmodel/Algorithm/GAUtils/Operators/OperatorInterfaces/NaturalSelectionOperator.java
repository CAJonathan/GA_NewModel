package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.Algorithm.Individual;

import java.util.ArrayList;

public interface NaturalSelectionOperator {

    ArrayList<Individual> execute(ArrayList<Individual> individuals);
}
