package Utilities.GAUtils;

import Algorithm.Main;
import Utilities.Factors;

import java.util.ArrayList;

public class FitnessFactory {

    public static double fitness(ArrayList<Integer> chromosome){
        switch (Factors.GA_CHOSEN_FITNESS_FUNCTION){
            case 1:{
                return fitness1(chromosome);
            }

            case 2:{
                return fitness2(chromosome);
            }

            case 3:{
                return fitness3(chromosome);
            }

            default:{
                return 0.0;
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
     * @param chromosome
     * @return fitness score
     * @description return finess score as large values, user should sort the individuals ascending
     */
    private static double fitness2(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);

            double chargingTime = Factors.ALPHA * Factors.K * (Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin) / Factors.P.get(current);
            double moveTime = (1 - Factors.ALPHA) * Main.distances[previous][current] / Factors.WCE_V;
            fitnessScore += chargingTime + moveTime;

        }

        return fitnessScore;
    }

    /**
     * @author cajonathan
     * @param chromosome
     * @return fitness score
     * @description return finess score as large values, user should sort the individuals ascending
     */
    private static double fitness3(ArrayList<Integer> chromosome){
        double fitnessScore = 0.0;
        double time = 0.0;
        int length = chromosome.size();

        for(int i = 0 ; i < length ; i ++){
            int prev = i == 0 ? 0 : i - 1;
            int current = chromosome.get(i);

            double p = Factors.P.get(current);
            double distance = Main.distances[prev][current];
            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current) - p * time;

            double chargingTime = Factors.ALPHA * Factors.K * (remainingEnergy - Factors.SENSOR_Emin) / p;
            double moveTime = (1 - Factors.ALPHA) * distance / Factors.WCE_V;
            fitnessScore += chargingTime
                    + moveTime;

            time += distance / Factors.WCE_V + (Factors.SENSOR_Emax - remainingEnergy) / (Factors.WCE_U - p);
        }

        return fitnessScore;
    }
}
