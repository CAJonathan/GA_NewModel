import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Factors.INPUT_FILE_PATH));

        List<Pair<Double, Double>> data = new ArrayList<>();
        data.add(new Pair(Factors.SERVICE_STATION_X, Factors.SERVICE_STATION_Y));

        Factors.REMAINING_ENERGIES = new ArrayList<>();
        Factors.REMAINING_ENERGIES.add(0.0);

        Factors.P = new ArrayList<>();
        Factors.P.add(0.0);

        while (scanner.hasNextLine()){
            try{
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double p = scanner.nextDouble();
                double remainingEnergy = scanner.nextDouble();

                data.add(new Pair(x, y));
                Factors.REMAINING_ENERGIES.add(remainingEnergy);
                Factors.P.add(p);
                Factors.NUM_OF_SENSORS ++;
            } catch (Exception e){
                System.out.println("EOF reached!");
            }
        }
        scanner.close();

        for(int i = 0 ; i <= Factors.NUM_OF_SENSORS ; i ++){
            System.out.print(data.get(i).getValue0() + " ");
            System.out.print(data.get(i).getValue1() + " ");
            System.out.print(Factors.P.get(i) + " ");
            System.out.print(Factors.REMAINING_ENERGIES.get(i) + " ");
            System.out.println();
        }
    }

}
