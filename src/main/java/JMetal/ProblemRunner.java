package JMetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.operator.impl.crossover.SBXCrossover;
import org.uma.jmetal.operator.impl.mutation.PolynomialMutation;
import org.uma.jmetal.operator.impl.selection.BinaryTournamentSelection;
import org.uma.jmetal.operator.impl.selection.TournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.problem.multiobjective.MultiobjectiveTSP;
import org.uma.jmetal.problem.multiobjective.zdt.ZDT1;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.solution.PermutationSolution;
import org.uma.jmetal.solution.impl.DefaultIntegerPermutationSolution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.AlgorithmRunner;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;
import org.uma.jmetal.util.comparator.RankingComparator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ProblemRunner {

    public static void main(String[] args) throws JMetalException, FileNotFoundException, IOException {
        MyProblem problem;
        Algorithm<List<DefaultIntegerPermutationSolution>> algorithm;
        CrossoverOperator<DefaultIntegerPermutationSolution> crossover;
        MutationOperator<DefaultIntegerPermutationSolution> mutation;
        SelectionOperator<List<DefaultIntegerPermutationSolution>, DefaultIntegerPermutationSolution> selection;

        problem = new MyProblem(30);

        double crossoverProbability = 0.9 ;
        double crossoverDistributionIndex = 20.0 ;
        crossover = new MyCrossoverOperator() ;

        double mutationProbability = 1.0 / problem.getNumberOfVariables() ;
        double mutationDistributionIndex = 20.0 ;
        mutation = new MyMutationOperator();

        selection = new TournamentSelection<DefaultIntegerPermutationSolution>(5);

        algorithm = new NSGAIIBuilder<PermutationSolution>(problem, crossover, mutation)
                .setSelectionOperator(selection)
                .setMaxEvaluations(25000)
                .setPopulationSize(200)
                .build() ;

        AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm)
                .execute() ;

        List<DefaultIntegerPermutationSolution> population = algorithm.getResult() ;
    }
}
