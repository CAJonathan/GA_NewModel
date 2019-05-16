import Utilities.Factors;
import Utilities.IOParser;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {
        IOParser parser = new IOParser();
        List<String> chromosomeStr = Arrays.asList("51 69 54 47 11 36 12 39 34 61 57 15 33 68 25 40 53 30 28 20 16 70 9 5 35 27 14 56 3 13 62 63 2 23 67 19 52 50 65 17 37 4 49 60 55 22 59 64 48 58 42 38 10 8 46 6 29 24 41 43 26 32 45 44 7 1 31 21 66 18".split(" "));
        List<Integer> chromosome = chromosomeStr.stream().map(chStr -> Integer.parseInt(chStr)).collect(Collectors.toList());
        parser.initDistanceMatrixWithPointsSetData();
        System.out.println(fitness6(chromosome));
    }

    private static double fitness6(List<Integer> chromosome){
        double fitnessScore = 0.0;
        int numOfGenes = chromosome.size();

        double totalDistance = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);
            totalDistance += Factors.distances[previous][current];
        }

        double tMove = (totalDistance + Factors.distances[chromosome.get(numOfGenes - 1)][0]) / Factors.WCE_V;
        double eMove =  Factors.WCE_P_MOVE * tMove;
        double eCharge = Factors.WCE_Emc - eMove;
        double tCharge = eCharge / Factors.WCE_U;

        double T = tMove + tCharge;

        double[] tChargeMinForEachSensor = new double[numOfGenes];
        for(int i = 0 ; i < numOfGenes ; i ++){
            int current = chromosome.get(i);
            double tChargeTmp = (T*Factors.P.get(current) - Factors.REMAINING_ENERGIES.get(current) + Factors.SENSOR_Emin) / (Factors.WCE_U - Factors.P.get(current));
            tChargeMinForEachSensor[i] = tChargeTmp < 0 ? 0 : tChargeTmp;
        }

        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            int current = chromosome.get(i);

            double distance = Factors.distances[previous][current];
            time += distance / Factors.WCE_V;

            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current)- Factors.P.get(current) * time;
            if(remainingEnergy < Factors.SENSOR_Emin){
                if(i > 0){
                    int idx = 0;
                    double max = 0.0;
                    for(int j = 0 ; j < i ; j ++){
                        if(tChargeMinForEachSensor[j] > max){
                            max = tChargeMinForEachSensor[j];
                            idx = j;
                        }
                    }

                    if(max > tChargeMinForEachSensor[i]){
                        double timeTmp = time - max;
                        double remainingEnergyTmp = Factors.REMAINING_ENERGIES.get(current) - Factors.P.get(current) * timeTmp;
                        if(remainingEnergyTmp >= Factors.SENSOR_Emin){
                            time = time - max + tChargeMinForEachSensor[i];
                            tChargeMinForEachSensor[idx] = 0;
                        }
                    }
                }
                fitnessScore ++;
            } else{
                time += tChargeMinForEachSensor[i];
            }
        }

        return fitnessScore;
    }
}
