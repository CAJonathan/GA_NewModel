package Algorithm.GAUtils.Operators.OperatorInterfaces;

import Algorithm.Individual;
import org.javatuples.Pair;

public interface CrossoverOperator {
    Pair<Individual, Individual> execute(Individual indDad, Individual indMom);
}
