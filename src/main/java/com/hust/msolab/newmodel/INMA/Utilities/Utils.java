package com.hust.msolab.newmodel.INMA.Utilities;

import org.javatuples.Pair;

import java.io.File;

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

    public static void cloneDirectory(String src, String des) {
        recursiveClone(src, src, des);
    }
    private static void recursiveClone(String current, String src, String des){
        File folder = new File(current);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String directory = subFile.getParent();
                directory = directory.replace(src, des);
                File f = new File(directory);
                if(!f.exists()){
                    f.mkdirs();
                }
            } else{
                recursiveClone(subFile.getAbsolutePath(), src, des);
            }
        }
    }
}
