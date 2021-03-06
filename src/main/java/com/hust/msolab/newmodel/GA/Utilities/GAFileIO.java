package com.hust.msolab.newmodel.GA.Utilities;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Class quy định các đọc dữ liệu đầu vào và cách thức output kết quả cho thuật toán GA
 *
 * @author sondn 30/04/2019
 */

public class GAFileIO {

    public void output(Individual bestInd, double executionTime, String outputFilePath) throws IOException{
        File resultFile = new File(outputFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true));

        writer.write("\n");
        List<Integer> bestPath = bestInd.getChromosome();
        for(Integer sensor : bestPath){
            writer.write(sensor + " ");
        }

        writer.write("\nBest fitness: " + String.format("%.2f", bestInd.getFitnessScore()));

        writer.write("\nExecution time: " + executionTime);

        writer.close();
    }

    public void output(Individual bestInd, Individual worstInd, String outputFilePath) throws IOException{
        File resultFile = new File(outputFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true));

        List<Integer> bestPath = bestInd.getChromosome();
        for(Integer sensor : bestPath){
            writer.write(sensor + " ");
        }

        writer.write("\nBest fitness: " + String.format("%.2f\n", bestInd.getFitnessScore()));

        List<Integer> worstPath = worstInd.getChromosome();
        for(Integer sensor : worstPath){
            writer.write(sensor + " ");
        }

        writer.write("\nWorst fitness: " + String.format("%.2f\n", worstInd.getFitnessScore()));

        writer.close();
    }

    public void output(Individual bestInd, Individual worstInd, double mean, double stdvt, String outputFilePath) throws IOException{
        File resultFile = new File(outputFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true));

        List<Integer> bestPath = bestInd.getChromosome();
        for(Integer sensor : bestPath){
            writer.write(sensor + " ");
        }

        writer.write("\nBest fitness: " + String.format("%.2f\n", bestInd.getFitnessScore()));

        List<Integer> worstPath = worstInd.getChromosome();
        for(Integer sensor : worstPath){
            writer.write(sensor + " ");
        }

        writer.write("\nWorst fitness: " + String.format("%.2f\n", worstInd.getFitnessScore()));

        writer.write("\nMean: " + String.format("%.2f\n", mean));
        writer.write("\nStandard deviation: " + String.format("%.2f\n", stdvt));

        writer.close();
    }

    public void output(List<Individual> inds, double mean, double stdvt, String outputFilePath) throws IOException{
        File resultFile = new File(outputFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true));

        for(Individual ind : inds){
            List<Integer> bestPath = ind.getChromosome();
            for(Integer sensor : bestPath){
                writer.write(sensor + " ");
            }
            writer.write("\nFitness: " + String.format("%.2f\n", ind.getFitnessScore()));


            writer.write("\n\nMean: " + String.format("%.2f\n", mean));
            writer.write("\nStandard deviation: " + String.format("%.2f\n", stdvt));
        }

        writer.close();
    }

    public void parseData(String filePath) throws IOException{
        List<Pair<Double, Double>> pointsSet = readData(filePath);
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
    private List<Pair<Double, Double>> readData(String filePath) throws IOException{
        Scanner scanner = new Scanner(new File(filePath));

        List<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        Factors.REMAINING_ENERGIES = new ArrayList<>();
        Factors.REMAINING_ENERGIES.add(0.0);

        Factors.P = new ArrayList<>();
        Factors.P.add(0.0);

        Factors.NUM_OF_SENSORS = 0;

        while (scanner.hasNextLine()){
            try{
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double p = scanner.nextDouble();
                double remainingEnergy = scanner.nextDouble();

                data.add(new Pair(x, y));
                Factors.REMAINING_ENERGIES.add(remainingEnergy);
                Factors.P.add(p);
                Factors.NUM_OF_SENSORS ++;
            } catch (Exception e){
                System.out.println("EOF reached!");
                break;
            }
        }
        scanner.close();

        return data;
    }
}
