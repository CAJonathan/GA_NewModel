package JMetal;

import Algorithm.Main;
import Utilities.Factors;
import Utilities.IOParser;
import org.uma.jmetal.problem.impl.AbstractIntegerPermutationProblem;
import org.uma.jmetal.solution.PermutationSolution;

import java.io.IOException;

public class MyProblem extends AbstractIntegerPermutationProblem {

    protected int numberOfSensors ;
    protected double [][] distanceMatrix;

    public MyProblem(Integer numberOfVariables) throws IOException {
        setNumberOfVariables(numberOfVariables);
        setNumberOfObjectives(2);
        setName("New Model");

        IOParser parser = new IOParser();
        distanceMatrix = parser.initDistanceMatrixWithPointsSetData();
        numberOfSensors = numberOfVariables;
    }

    public void evaluate(PermutationSolution<Integer> solution){
        double fitness1 = 0.0;
        double fitness2 = 0.0;

        final double veryLargeNumber = 999999;

        int numOfGenes = solution.getNumberOfVariables();

        double time = 0.0;
        for(int i = 0 ; i < numOfGenes ; i ++){
            int previous = i == 0 ? 0 : solution.getVariableValue(i - 1);
            int current = solution.getVariableValue(i);
            double distance = Main.distances[previous][current];
            time += distance / Factors.WCE_V;

            double remainingEnergy = Factors.REMAINING_ENERGIES.get(current) - Factors.SENSOR_Emin - Factors.P.get(current) * time;
            if(remainingEnergy < 0){
                fitness1 += veryLargeNumber;
            } else{
                double sufferingTime = Factors.ALPHA * Factors.K * remainingEnergy / Factors.P.get(current);
                fitness1 += sufferingTime;
            }

            fitness2 += (1 - Factors.ALPHA) * distance / Factors.WCE_V;
        }

        solution.setObjective(0, fitness1);
        solution.setObjective(1, fitness2);
    }

    @Override
    public int getPermutationLength() {
        return numberOfSensors ;
    }
}
