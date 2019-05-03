package Utilities;

import org.javatuples.Pair;

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

    public static void main(String[] args){
        System.out.println(extractFilePath(Factors.INPUTFILE_NAME));
    }
}
