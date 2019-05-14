package Utilities;

import org.javatuples.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Utils {

    public static double euclideDistance(Pair<Double, Double> point1, Pair<Double, Double> point2){
        return Math.sqrt(Math.pow(point1.getValue0() - point2.getValue0(), 2) + Math.pow(point1.getValue1() - point2.getValue1(), 2));
    }

    public static int extractFilePath(String filePath){
        String[] fileExtracted = filePath.split("/");
        String fileName = fileExtracted[fileExtracted.length - 1];
        String[] fileNameParts = fileName.split("-");
        if(fileNameParts.length < 2){
            fileNameParts = fileName.split("\\.");
        }
        int numberPart = fileNameParts.length > 2 ? 1 : 0;
        String numOfSensorStr = fileNameParts[numberPart].substring(1);
        int numOfSensor = Integer.parseInt(numOfSensorStr);

        return numOfSensor;
    }

    public static ArrayList<Integer> Reverse(ArrayList<Integer> chromosome, int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            Collections.swap(chromosome, i, j);
            i ++;
            j --;
        }

        return chromosome;
    }

    public static void createDataBin(String rootFolderName){
        String dataFolder = Factors.PATH_TO_RESOURCE + "/" + rootFolderName + "/";
        File f1 = new File(dataFolder + "Normal_distribution_energy/High_energy/normal_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Normal_distribution_energy/High_energy/uniform_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Normal_distribution_energy/Medium_energy/normal_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Normal_distribution_energy/Medium_energy/uniform_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Normal_distribution_energy/Low_energy/normal_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Normal_distribution_energy/Low_energy/uniform_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Uniform_distribution_energy/normal_distribution_location");
        f1.mkdirs();
        f1 = new File(dataFolder + "Uniform_distribution_energy/uniform_distribution_location");
        f1.mkdirs();
    }

    public static void main(String[] args){
        createDataBin("Result3");
    }
}
