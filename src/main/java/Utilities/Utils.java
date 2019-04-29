package Utilities;

import org.javatuples.Pair;

public class Utils {

    public static double euclideDistance(Pair<Double, Double> point1, Pair<Double, Double> point2){
        return Math.sqrt(Math.pow(point1.getValue0() - point2.getValue0(), 2) + Math.pow(point1.getValue1() - point2.getValue1(), 2));
    }

    public static int extractFilePath(String filePath){
        String[] fileExtracted = filePath.split("/");
        String fileName = fileExtracted[fileExtracted.length - 1];
        String numOfSensorStr = fileName.split("-")[1].substring(1);
        int numOfSensor = Integer.parseInt(numOfSensorStr);

        return numOfSensor;
    }

//    public static void main(String[] args){
//        System.out.println(extractFilePath(Factors.INPUTFILE_NAME));
//    }
}
