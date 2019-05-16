package com.hust.msolab.newmodel.JMetal;

import org.uma.jmetal.problem.PermutationProblem;
import org.uma.jmetal.problem.impl.AbstractGenericProblem;
import org.uma.jmetal.solution.PermutationSolution;

public abstract class MyAbstractSolution extends AbstractGenericProblem<PermutationSolution<Integer>> implements
        PermutationProblem<PermutationSolution<Integer>> {

    /* Getters */

    /* Setters */

    @Override
    public PermutationSolution<Integer> createSolution() {
        return new MySolution(this) ;
    }
}
