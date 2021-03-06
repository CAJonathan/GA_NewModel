package com.hust.msolab.newmodel.GA.Utilities;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.io.*;
import java.nio.file.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class chứa một vài hàm tiện ích
 *
 * @author sondn on 30/04/2019
 */

public class Utils {

    public static double euclideDistance(Pair<Double, Double> point1, Pair<Double, Double> point2){
        return Math.sqrt(Math.pow(point1.getValue0() - point2.getValue0(), 2) + Math.pow(point1.getValue1() - point2.getValue1(), 2));
    }

    public static List<Integer> Reverse(List<Integer> list, int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            Collections.swap(list, i, j);
            i ++;
            j --;
        }

        return list;
    }

    public static List<Individual> sort(List<Individual> individuals){
        Collections.sort(individuals, (i1, i2) ->  Double.compare( i1.getFitnessScore(), i2.getFitnessScore()));
//        Collections.sort(individuals, (i1, i2) ->  Double.compare( i2.getFitnessScore(), i1.getFitnessScore()));
        return individuals;
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

    public static void copyContent(String src, String des) throws IOException{
        Files.copy(new File(src).toPath(), new File(des).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
