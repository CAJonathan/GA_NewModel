package Utilities.GAUtils;

import Algorithm.Main;
import Utilities.Factors;

import java.util.ArrayList;

public class FitnessFactory {

    public static double fitness(ArrayList<Integer> chromosome){
        switch (Factors.GA_CHOSEN_FITNESS_FUNCTION){

            case 2:{
                return fitness2(chromosome);
            }

            case 3:{
                return fitness3(chromosome);
            }

            default:{
                return fitness1(chromosome);
            }
        }
    }

    private static double fitness1(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            fitnessScore += Factors.ALPHA / (Factors.REMAINING_ENERGIES.get(current)) + (1 - Factors.ALPHA) * Factors.K / (Main.distances[previous][current]);
        }

        return fitnessScore;
    }


    /**
     * @author cajonathan
     * @param chromosome - individual's chromosome
     * @return fitness score
     */
    private static double fitness2(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);

            double sufferingTime = Factors.ALPHA * Factors.K * (Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin) / Factors.P.get(current);
            double moveTime = (1 - Factors.ALPHA) * Main.distances[previous][current] / Factors.WCE_V;
            fitnessScore += sufferingTime + moveTime;

        }

        return fitnessScore;
    }

    /**
     * @author cajonathan
     * @param chromosome - individual's chromosome
     * @return fitness score
     */
    private static double fitness3(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);

            double sufferingTime = Factors.ALPHA * Factors.K * (Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin) / Factors.P.get(current);
            double moveTime = (1 - Factors.ALPHA) * Main.distances[previous][current] / Factors.WCE_V;
            double priority = i * 1.0  / numOfGenes;
            fitnessScore += priority * sufferingTime + moveTime;

        }

        return fitnessScore;
    }
}
