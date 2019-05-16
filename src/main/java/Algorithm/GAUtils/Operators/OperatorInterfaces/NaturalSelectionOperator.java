package Algorithm.GAUtils.Operators.OperatorInterfaces;

import Algorithm.Individual;

import java.util.ArrayList;

public interface NaturalSelectionOperator {

    ArrayList<Individual> execute(ArrayList<Individual> individuals);
}
