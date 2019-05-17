package com.hust.msolab.newmodel.JMetal;

import com.hust.msolab.newmodel.JMetal.Operators.Crossover.MyCrossoverOperator;
import com.hust.msolab.newmodel.JMetal.Operators.Mutation.MyMutationOperator;
import com.hust.msolab.newmodel.Utilities.Factors;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.operator.impl.selection.TournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.problem.singleobjective.cec2005competitioncode.F08ShiftedRotatedAckleyGlobalOptBound;
import org.uma.jmetal.solution.impl.DefaultIntegerPermutationSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.AlgorithmRunner;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;

import java.io.IOException;
import java.util.List;

public class ProblemRunner extends AbstractAlgorithmRunner {

    public static void main(String[] args) throws JMetalException, IOException {
        Problem problem;
        Algorithm<List<MySolution>> algorithm;
        CrossoverOperator<MySolution> crossover;
        MutationOperator<MySolution> mutation;
        SelectionOperator<List<MySolution>, MySolution> selection;

        problem = new MyProblem(70);

        crossover = new MyCrossoverOperator() ;

        mutation = new MyMutationOperator();

        selection = new TournamentSelection<>(5);

        algorithm = new NSGAIIBuilder<MySolution>(problem, crossover, mutation)
                .setSelectionOperator(selection)
                .setMaxEvaluations(25000)
                .setPopulationSize(100)
                .build() ;

        AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm)
                .execute() ;

        List<MySolution> population = algorithm.getResult() ;
        output(population);
    }

    private static void output(List<MySolution> population){
        new SolutionListOutput(population)
                .setSeparator("\t")
                .setVarFileOutputContext(new DefaultFileOutputContext(Factors.JMETAL_OUTPUT_FOLDER + "/VAR.tsv"))
                .setFunFileOutputContext(new DefaultFileOutputContext(Factors.JMETAL_OUTPUT_FOLDER + "/FUN.tsv"))
                .print();
    }
}
