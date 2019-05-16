package JMetal.Operators.Crossover;

import JMetal.MySolution;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.solution.impl.DefaultIntegerPermutationSolution;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyCrossoverOperator implements CrossoverOperator<MySolution> {

    @Override
    public List<MySolution> execute(List<MySolution> permutationSolutions) {
        MySolution dad = permutationSolutions.get(0);
        MySolution mom = permutationSolutions.get(1);
        int numOfGene = dad.getNumberOfVariables();

        MySolution child1 = dad.copy();
        MySolution child2 = mom.copy();

        int cuttingPoint = (new Random()).nextInt(numOfGene - 2) + 1;
        boolean[] visited1 = new boolean[numOfGene + 1];
        boolean[] visited2 = new boolean[numOfGene + 1];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        for(int i = 0 ; i < cuttingPoint ; i ++){
            int gene1 = dad.getVariableValue(i);
            int gene2 = mom.getVariableValue(i);
            visited1[gene1] = true;
            visited2[gene2] = true;
        }

        for(int i = cuttingPoint ; i < numOfGene ; i ++){
            for(int j = 0 ; j < mom.getNumberOfVariables() ; j ++){
                int gene1 = (int)mom.getVariableValue(j);
                if(!visited1[gene1]){
                    child1.setVariableValue(i, gene1);
                    visited1[gene1] = true;
                    break;
                }
            }

            for(int j = 0 ; j < dad.getNumberOfVariables() ; j ++){
                int gene2 = (int)dad.getVariableValue(j);
                if(!visited2[gene2]){
                    child2.setVariableValue(i, gene2);
                    visited2[gene2] = true;
                    break;
                }
            }
        }
        List<MySolution> offspring = Arrays.asList(child1, child2);
        return offspring;
    }

    @Override
    public int getNumberOfRequiredParents() {
        return 2;
    }

    @Override
    public int getNumberOfGeneratedChildren() {
        return 2;
    }
}
