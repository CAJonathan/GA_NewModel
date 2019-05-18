import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Factories.Factory;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Factors.NUM_OF_SENSORS = 9;

        reproduct(Arrays.asList(8, 1, 4, 2, 3, 5, 7, 6, 9), Arrays.asList(9, 4, 2, 7, 1, 6, 5, 3, 8));
    }



    private static Individual reproduct(List<Integer> dadChromosome, List<Integer> momChromosome){
        Random rand = new Random();

        boolean [] isInOffspringChromosome = new boolean[Factors.NUM_OF_SENSORS + 1];
        boolean [] isEmptyPosition = new boolean[Factors.NUM_OF_SENSORS];
        Arrays.fill(isInOffspringChromosome, false);
        Arrays.fill(isEmptyPosition, true);
        isInOffspringChromosome[0] = true;

        Integer[] childChromosome = new Integer[Factors.NUM_OF_SENSORS];

        int rmxLength = rand.nextInt(Factors.NUM_OF_SENSORS);
        int beginPosition = rand.nextInt(Factors.NUM_OF_SENSORS - rmxLength);
        int endPosition = beginPosition + rmxLength;

        for(int i = beginPosition ; i < endPosition ; i ++) {
            childChromosome[i] = dadChromosome.get(i);
            isEmptyPosition[i] = false;
            isInOffspringChromosome[dadChromosome.get(i)] = true;
        }

        for(int i = beginPosition ; i < endPosition ; i ++) {
            int gene = momChromosome.get(i);

            if(isInOffspringChromosome[gene]) {
                continue;
            } else {
                int freeIndex = i;
                while(!isEmptyPosition[freeIndex]) {
                    freeIndex = momChromosome.indexOf(dadChromosome.get(freeIndex));
                }

                childChromosome[freeIndex] = gene;
                isEmptyPosition[freeIndex] = false;
                isInOffspringChromosome[gene] = true;
            }
        }



        return new Individual(Arrays.asList(childChromosome));
    }

}
