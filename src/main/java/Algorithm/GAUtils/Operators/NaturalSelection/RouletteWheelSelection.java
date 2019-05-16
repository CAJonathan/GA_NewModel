package Algorithm.GAUtils.Operators.NaturalSelection;

import Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import Algorithm.Individual;
import Utilities.Factors;

import java.util.ArrayList;
import java.util.Random;

public class RouletteWheelSelection implements NaturalSelectionOperator {

    public ArrayList<Individual> execute(ArrayList<Individual> individuals) {
        ArrayList<Individual> chosenIndividuals = new ArrayList<>();
        while(chosenIndividuals.size() < Factors.GA_POPULATION_SIZE){
            int size = individuals.size();
            double sumFitness = individuals.stream().mapToDouble(ind -> ind.getFitnessScore()).sum();
            double[] rottleWheel = new double[size + 1];
            rottleWheel[0] = 0.0;
            for(int i = 0 ; i < size ; i ++){
                rottleWheel[i + 1] = rottleWheel[i] + sumFitness / individuals.get(i).getFitnessScore();
            }

            Random rand = new Random();

            double guideline = rand.nextDouble() * rottleWheel[size];
            for(int i = 1 ; i < rottleWheel.length ; i ++){
                if(rottleWheel[i] > guideline){
                    chosenIndividuals.add(individuals.remove(i - 1));
                    break;
                }
            }
        }

        return chosenIndividuals;
    }
}
