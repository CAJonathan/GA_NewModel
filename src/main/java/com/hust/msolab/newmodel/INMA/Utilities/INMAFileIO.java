package com.hust.msolab.newmodel.INMA.Utilities;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.IOParser;
import com.hust.msolab.newmodel.INMA.Device.Sensor;
import org.javatuples.Pair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class INMAFileIO extends IOParser {
    public Sensor[] readData(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        Factors.NUM_OF_SENSORS = Utils.extractFilePath(filePath);
        Sensor[] sensors = new Sensor[Factors.NUM_OF_SENSORS + 1];

        List<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        for(int i = 1 ; i <= Factors.NUM_OF_SENSORS ; i ++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double p = scanner.nextDouble();
            double e = scanner.nextDouble();

            data.add(new Pair(x, y));
            sensors[i] = new Sensor(i, e);

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

        return sensors;
    }
}
