package Utilities;

import Algorithm.Individual;
import org.javatuples.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOParser {

    public void output(Individual individual, double avgFitness, Individual worstInd, String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        ArrayList<Integer> path = individual.getChromosome();
        for(Integer sensor : path){
            writer.write(sensor + " ");
        }

        writer.write("\nBest fitness: " + String.format("%.2f", individual.getFitnessScore()));

        ArrayList<Integer> worst = worstInd.getChromosome();
        for(Integer sensor : worst){
            writer.write(sensor + " ");
        }

        writer.write("\nWorst fitness: " + worstInd.getFitnessScore());

        writer.write("\nAverage fitness: " + String.format("%.2f", avgFitness));

        writer.write("\nAlpha: " + String.format("%.2f", Factors.ALPHA));

        writer.write("\nK: " + String.format("%.2f", Factors.K));

        writer.write("\nCrossover probability: " + String.format("%.2f", Factors.GA_CROSSOVER_PROBABILITY));

        writer.write("\nMutation probability: " + String.format("%.2f", Factors.GA_MUTATION_PROBABILITY));

        writer.write("\nChange mutation operator probability 1: " + String.format("%.2f", Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY1));

        writer.write("\nChange mutation operator probability 2: " + String.format("%.2f", Factors.GA_CHANGE_MUTATION_OPERATION_PROBABILITY2));

        writer.close();
    }

    public void initDistanceMatrixWithPointsSetData() throws IOException{
        Factors factors = new Factors();
        String filePath = factors.inputFilePath();
        ArrayList<Pair<Double, Double>> pointsSet = readPointsSetData(filePath);
        int numOfNode = Factors.NUM_OF_SENSORS + 1;
        double [][] distances = new double[numOfNode][numOfNode];

        for(int i = 0 ; i < pointsSet.size() - 1 ; i ++){
            for(int j = i + 1 ; j < pointsSet.size() ; j ++){
                distances[i][j] = (i != j) ? Utils.euclideDistance(pointsSet.get(i), pointsSet.get(j)) : 0.0;
                distances[j][i] = distances[i][j];
            }
        }

        Factors.distances = distances;
    }

    private ArrayList<Pair<Double, Double>> readPointsSetData(String filePath) throws IOException{

        Scanner scanner = new Scanner(new File(filePath));
        Factors.NUM_OF_SENSORS = Utils.extractFilePath(filePath);

        ArrayList<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        Factors.REMAINING_ENERGIES = new ArrayList<>();
        Factors.REMAINING_ENERGIES.add(0.0);

        Factors.P = new ArrayList<>();
        Factors.P.add(0.0);

        for(int i = 0 ; i < Factors.NUM_OF_SENSORS ; i ++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double p = scanner.nextDouble();
            double remainingEnergy = scanner.nextDouble();

            data.add(new Pair(x, y));
            Factors.REMAINING_ENERGIES.add(remainingEnergy);
            Factors.P.add(p);
        }
        scanner.close();
        return data;
    }
}
