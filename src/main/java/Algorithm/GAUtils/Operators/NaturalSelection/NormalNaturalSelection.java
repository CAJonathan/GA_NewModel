package Algorithm.GAUtils.Operators.NaturalSelection;

import Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import Algorithm.Individual;
import Utilities.Factors;

import java.util.ArrayList;

public class NormalNaturalSelection implements NaturalSelectionOperator {



    public ArrayList<Individual> execute(ArrayList<Individual> individuals){
        while(individuals.size() > Factors.GA_POPULATION_SIZE) {
            individuals.remove(individuals.size() - 1);
        }

        return individuals;
    }
}
