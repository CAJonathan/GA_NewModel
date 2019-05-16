package JMetal;

import org.uma.jmetal.problem.PermutationProblem;
import org.uma.jmetal.problem.impl.AbstractGenericProblem;
import org.uma.jmetal.solution.PermutationSolution;
import org.uma.jmetal.solution.impl.DefaultIntegerPermutationSolution;

public abstract class MyAbstractSolution extends AbstractGenericProblem<PermutationSolution<Integer>> implements
        PermutationProblem<PermutationSolution<Integer>> {

    /* Getters */

    /* Setters */

    @Override
    public PermutationSolution<Integer> createSolution() {
        return new MySolution(this) ;
    }
}
