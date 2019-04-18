import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Utilities.Factors;
import org.javatuples.Pair;

public class Main {
    public static int numOfNode = 21;
    public static int populationSize = 200;
    public static double [][] distances = new double[numOfNode][numOfNode];
    public static int loop = 500;

    public static void main(String[] args) throws IOException{
        try {
            initDistanceMatrixWithPointsSetData(args[0] + "situation2.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        double minLength = 0;
        double opCp = 0;
        double opCco = 0;
        double opMp = 0;
        double opCmo = 0;

        Individual bestInd = null;
        ArrayList<Individual> inds = null;

        for(double cp = 0.3 ; cp < 0.9 ; cp += 0.1){
            for(double cco = 0.1 ; cco < 0.9 ; cco += 0.1) {
                for (double mp = 0.05; mp < 0.2; mp += 0.01) {
                    for (double cmo = 0.1; cmo < 0.9; cmo += 0.1) {
                        Population initialPopulation = new Population(populationSize, numOfNode - 1);
                        for (int i = 0; i < loop; i++) {
                            initialPopulation.crossOver(cp, cco);
                            initialPopulation.mutate(mp, cmo);
                            initialPopulation.sort();
                            initialPopulation.naturalSelection();
                        }
                        double sol = initialPopulation.bestSolution();
                        if (minLength < sol) {
                            minLength = sol;
                            opCp = cp;
                            opCco = cco;
                            opMp = mp;
                            opCmo = cmo;

                            bestInd = initialPopulation.bestIndividual();
                            inds = initialPopulation.getIndividuals();
                        }
                        System.out.println(cp + " ~ " + cco + " ~ " + mp + " ~ " + cmo);
                    }
                }
            }
        }

        ArrayList<Integer> chr = bestInd.getChromosome();
        for(Integer s : chr){
            System.out.print(s + " ");
        }
        System.out.println("\n" + minLength);
        System.out.println(opCp + " ~ " + opCco + " ~ " + opMp + " ~ " + opCmo);
        output(inds, args[0]);

    }

    private static void output(ArrayList<Individual> individuals, String prefixPath) throws IOException{
        String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";

        BufferedWriter writer = new BufferedWriter(new FileWriter(prefixPath + "result.txt"));
        for(int i = 0 ; i < individuals.size() ; i ++){
            ArrayList<Integer> ch = individuals.get(i).getChromosome();
            for(int j = 0 ; j < ch.size() ; j ++){
                writer.write(ch.get(j) + " ");
            }
            writer.newLine();
        }
        writer.close();
    }

    private static void initDistanceMatrixWithMatrixData(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        for(int i = 0 ; i < numOfNode ; i ++) {
            for(int j = 0 ; j < numOfNode ; j ++) {
                distances[i][j] = scanner.nextDouble();
            }
        }
    }

    private static void initDistanceMatrixWithPointsSetData(String filePath) throws IOException{
        ArrayList<Pair<Double, Double>> pointsSet = readPointsSetData(filePath);

        for(int i = 0 ; i < pointsSet.size() - 1 ; i ++){
            for(int j = i + 1 ; j < pointsSet.size() ; j ++){
                distances[i][j] = (i != j) ? euclideDistance(pointsSet.get(i), pointsSet.get(j)) : 0.0;
                distances[j][i] = distances[i][j];
            }
        }
    }

    private static ArrayList<Pair<Double, Double>> readPointsSetData(String filePath) throws IOException{

        Scanner scanner = new Scanner(new File(filePath));

        ArrayList<Pair<Double, Double>> data = new ArrayList<>();
        Factors.remainingEnergy = new ArrayList<>();

        Factors.remainingEnergy.add(0.0);
        data.add(new Pair(0.0, 0.0));

        for(int i = 0 ; i < numOfNode - 1 ; i ++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            double energy = scanner.nextDouble();
            Factors.remainingEnergy.add(energy);
            data.add(new Pair(x, y));
        }

        return data;
    }

    private static double euclideDistance(Pair<Double, Double> point1, Pair<Double, Double> point2){
        return Math.sqrt(Math.pow(point1.getValue0() - point2.getValue0(), 2) + Math.pow(point1.getValue1() - point2.getValue1(), 2));
    }
}
