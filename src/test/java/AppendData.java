import Algorithm.Main;
import Utilities.Factors;
import Utilities.IOParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppendData {

    private static List<Integer> readPath(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String pathStr = br.readLine();
        br.close();

        List<Integer> path = Arrays.asList(pathStr.split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());

        return path;
    }

    public static void main(String[] args) throws IOException{
        String dataFilePath = Factors.INPUTFILE_PATH_TO_DATA_FOLDER + Factors.DISTRIBUTION_ENERGY_PREFIX + Factors.REMAINING_ENERGY_PREFIX + Factors.DISTRIBUTION_LOCATION_PREFIX + Factors.INPUTFILE_NAME;
        String resultFilePath = Factors.OUTPUT_PATH_TO_RESULT_FOLDER + Factors.DISTRIBUTION_ENERGY_PREFIX + Factors.REMAINING_ENERGY_PREFIX + Factors.DISTRIBUTION_LOCATION_PREFIX + Factors.OUTPUTFILE_NAME;
        List<Integer> path = readPath(resultFilePath);
        List<Double> consumptedMovingEnergy = new ArrayList<>();
        IOParser parser = new IOParser();
        double[][] distances = parser.initDistanceMatrixWithPointsSetData(dataFilePath);
        double time = 0;
        for(int i = 0 ; i < path.size() + 1 ; i ++){
            int current = i >= path.size() ? 0 : path.get(i);
            int prev = i == 0 ? 0 : path.get(i - 1);
            time += distances[prev][current] / Factors.WCE_V;
            consumptedMovingEnergy.add(time * Factors.WCE_P_MOVE);
        }
        append(consumptedMovingEnergy, resultFilePath);
    }

    private static void append(List<Double> moveEnergyConsumpted, String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write("\nConsumpted moving energy: ");
        for(Double energy : moveEnergyConsumpted){
            writer.write(String.format("%.2f ", energy));
        }

        writer.close();
    }
}
