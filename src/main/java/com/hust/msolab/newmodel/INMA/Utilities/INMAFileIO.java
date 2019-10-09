package com.hust.msolab.newmodel.INMA.Utilities;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import com.hust.msolab.newmodel.INMA.Device.Sensor;
import org.javatuples.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class INMAFileIO {
    public Sensor[] readData(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        List<Sensor> sensorList = new ArrayList<>();

        List<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        Factors.REMAINING_ENERGIES = new ArrayList<>();
        Factors.REMAINING_ENERGIES.add(0.0);

        Factors.NUM_OF_SENSORS = 0;

        sensorList.add(null);
        while (scanner.hasNextLine()){
            String[] lineArr = scanner.nextLine().split(" ");
            if(lineArr.length > 1){
                double x = Double.parseDouble(lineArr[0]);
                double y = Double.parseDouble(lineArr[1]);
                double p = Double.parseDouble(lineArr[2]);
                double e = Double.parseDouble(lineArr[3]);

                data.add(new Pair(x, y));
                Factors.NUM_OF_SENSORS ++;
                sensorList.add(new Sensor(Factors.NUM_OF_SENSORS, e));
                Factors.REMAINING_ENERGIES.add(e);
            } else {
                lineArr = scanner.nextLine().split(" ");
                Factors.DURING = Double.parseDouble(lineArr[0]);
                System.out.println("EOF reached!");
                break;
            }
        }
        scanner.close();

        int numOfNode = Factors.NUM_OF_SENSORS + 1;
        Factors.distances = new double[numOfNode][numOfNode];
        for(int i = 0 ; i < data.size() - 1 ; i ++){
            for(int j = i + 1 ; j < data.size() ; j ++){
                Factors.distances[i][j] = (i != j) ? Utils.euclideDistance(data.get(i), data.get(j)) : 0.0;
                Factors.distances[j][i] = Factors.distances[i][j];
            }
        }

        return sensorList.toArray(new Sensor[numOfNode]);
    }

    public void output(List<Integer> schedule, int numOfDeath, double executionTime, String outputFilePath) throws IOException{
        File resultFile = new File("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/DataINMA/P2CI-ResultICC/Sen3U=5");
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile, true));

//        writer.write("Schedule:");
//        for(Integer sensor : schedule){
//            writer.write(sensor + " ");
//        }
        String[] fileNameArr = outputFilePath.split("/");
        String fileName = fileNameArr[fileNameArr.length - 1];
        writer.write("Number of Deaths: " + numOfDeath + " on file: " + fileName + "\n");

        writer.close();
    }
}
