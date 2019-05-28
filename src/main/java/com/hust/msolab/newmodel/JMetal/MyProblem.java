package com.hust.msolab.newmodel.JMetal;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.IOParser;
import org.uma.jmetal.solution.PermutationSolution;

import java.io.IOException;

public class MyProblem extends MyAbstractSolution {

    public MyProblem() throws IOException {
        IOParser parser = new IOParser();
        parser.parseData(Factors.INPUT_FILE_PATH);

        setNumberOfVariables(Factors.NUM_OF_SENSORS);
        setNumberOfObjectives(2);
        setName("New Model");
    }

    @Override
    public PermutationSolution<Integer> createSolution() {
        return super.createSolution();
    }

    public void evaluate(PermutationSolution<Integer> solution){
        double fitness1 = 0.0;
        double fitness2 = 0.0;

        final double veryLargeNumber = 5000;

        int numOfGenes = solution.getNumberOfVariables();
        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : solution.getVariableValue(i - 1);
            int current = solution.getVariableValue(i);
            double distance = Factors.distances[previous][current];
            time += distance / Factors.WCE_V;

            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin - Factors.P.get(current) * time;
            if(remainingEnergy < 0){
                fitness1 += veryLargeNumber;
            } else{
                double sufferingTime = Factors.K * remainingEnergy / Factors.P.get(current);
                fitness1 += sufferingTime;
            }

            fitness2 += distance / Factors.WCE_V;
        }

        solution.setObjective(0, fitness1);
        solution.setObjective(1, fitness2);
    }

    @Override
    public int getPermutationLength() {
        return Factors.NUM_OF_SENSORS ;
    }
}
