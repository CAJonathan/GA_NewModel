package Algorithm.GAUtils;

import Algorithm.Individual;
import Utilities.Factors;

import java.util.ArrayList;
import java.util.Random;

public class NaturalSelectionFactory {

    /**
     * @author cajonathan
     * @param individuals - individuals
     * @return Selected individuals
     */
    public static ArrayList<Individual> naturalSelection(ArrayList<Individual> individuals){
        switch (Factors.GA_CHOSEN_NATURAL_SELECTION_FUNCTION){
            default:{
                return normalNaturalSelection(individuals);
            }

            case 2:{
                return rouletteWheelSelection(individuals);
            }
        }
    }

    public static ArrayList<Individual> rouletteWheelSelection(ArrayList<Individual> individuals){
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

    private static ArrayList<Individual> normalNaturalSelection(ArrayList<Individual> individuals){
        while(individuals.size() > Factors.GA_POPULATION_SIZE) {
            individuals.remove(individuals.size() - 1);
        }

        return individuals;
    }
}
