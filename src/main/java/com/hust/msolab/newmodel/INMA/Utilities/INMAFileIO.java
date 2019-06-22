package com.hust.msolab.newmodel.INMA.Utilities;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.IOParser;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
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
        Sensor[] sensors = new Sensor[Factors.NUM_OF_SENSORS + 1];

        List<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        Factors.REMAINING_ENERGIES = new ArrayList<>();
        Factors.REMAINING_ENERGIES.add(0.0);

        Factors.NUM_OF_SENSORS = 0;

        while (scanner.hasNextLine()){
            try{
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double p = scanner.nextDouble();
                double e = scanner.nextDouble();

                data.add(new Pair(x, y));
                Factors.NUM_OF_SENSORS ++;
                sensors[Factors.NUM_OF_SENSORS] = new Sensor(Factors.NUM_OF_SENSORS, e);
                Factors.REMAINING_ENERGIES.add(e);
            } catch (Exception e){
                System.out.println("EOF reached!");
                break;
            }
        }
        scanner.close();

        for(int i = 0 ; i < data.size() - 1 ; i ++){
            for(int j = i + 1 ; j < data.size() ; j ++){
                Factors.distances[i][j] = (i != j) ? Utils.euclideDistance(data.get(i), data.get(j)) : 0.0;
                Factors.distances[j][i] = Factors.distances[i][j];
            }
        }

        return sensors;
    }
}
