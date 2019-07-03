package com.hust.msolab.newmodel.GA.Experiment;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.GAFileIO;
import com.hust.msolab.newmodel.GA.Algorithm.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *  Class chung dùng để chạy thực nghiệm một file dữ liệu. trên mỗi file, thuật toán GA được chạy
 * nhiều lần và kết quả tốt nhất sẽ được lấy ra
 *
 * @author sondn on 07/05/2019
 */

public class Experiment {

    public static int LOOP = 30;

    public static void main(String[] args){
        run(Factors.INPUT_FILE_PATH, Factors.OUTPUT_FILE_PATH);
    }

    public static void run(String inputFilePath, String outputFilePath){
        try{
            List<Individual> goodIndividuals = new ArrayList<>();
            List<Individual> badIndividuals = new ArrayList<>();
            List<Double> executionTimes = new LinkedList<>();

            System.out.println(inputFilePath);
            GAFileIO parser = new GAFileIO();
            parser.parseData(inputFilePath);
            for(int i = 0 ; i < LOOP ; i ++){
                GeneticAlgorithm ag = new GeneticAlgorithm();
                ag.solve();
                goodIndividuals.add(ag.getSolution());
                badIndividuals.add(ag.getBadSolution());
                executionTimes.add(ag.getExecutionTime());
                System.out.print("====>");
            }
            System.out.println();

            Collections.sort(goodIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Collections.sort(badIndividuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
            Individual bestInd = goodIndividuals.get(0);
            Individual worstInd = badIndividuals.get(badIndividuals.size() - 1);
            Double executionTimeAvg = executionTimes.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

            parser.output(bestInd, executionTimeAvg, outputFilePath);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
