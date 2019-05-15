//package JMetal;
//
//import org.uma.jmetal.algorithm.Algorithm;
//import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
//import org.uma.jmetal.operator.CrossoverOperator;
//import org.uma.jmetal.operator.MutationOperator;
//import org.uma.jmetal.operator.SelectionOperator;
//import org.uma.jmetal.operator.impl.crossover.SBXCrossover;
//import org.uma.jmetal.operator.impl.mutation.PolynomialMutation;
//import org.uma.jmetal.operator.impl.selection.BinaryTournamentSelection;
//import org.uma.jmetal.problem.Problem;
//import org.uma.jmetal.problem.multiobjective.MultiobjectiveTSP;
//import org.uma.jmetal.problem.multiobjective.zdt.ZDT1;
//import org.uma.jmetal.solution.DoubleSolution;
//import org.uma.jmetal.solution.PermutationSolution;
//import org.uma.jmetal.util.AbstractAlgorithmRunner;
//import org.uma.jmetal.util.AlgorithmRunner;
//import org.uma.jmetal.util.JMetalException;
//import org.uma.jmetal.util.comparator.RankingAndCrowdingDistanceComparator;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.List;
//
//public class ProblemRunner {
//
//    public static void main(String[] args) throws JMetalException, FileNotFoundException, IOException {
//        MyProblem problem;
//        Algorithm<List<PermutationSolution>> algorithm;
//        CrossoverOperator<PermutationSolution> crossover;
//        MutationOperator<PermutationSolution> mutation;
//        SelectionOperator<List<PermutationSolution>, DoubleSolution> selection;
//
//        problem = new MyProblem(30);
//
//        double crossoverProbability = 0.9 ;
//        double crossoverDistributionIndex = 20.0 ;
//        crossover = new MyCrossoverOperator() ;
//
//        double mutationProbability = 1.0 / problem.getNumberOfVariables() ;
//        double mutationDistributionIndex = 20.0 ;
//        mutation = new PolynomialMutation(mutationProbability, mutationDistributionIndex) ;
//
//        selection = new BinaryTournamentSelection<>(new RankingAndCrowdingDistanceComparator<>());
//
//        algorithm = new NSGAIIBuilder<DoubleSolution>()
//                .setSelectionOperator(selection)
//                .setMaxEvaluations(25000)
//                .setPopulationSize(100)
//                .build() ;
//
//        AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm)
//                .execute() ;
//
//        List<PermutationSolution> population = algorithm.getResult() ;
//        long computingTime = algorithmRunner.getComputingTime() ;
//    }
//}
