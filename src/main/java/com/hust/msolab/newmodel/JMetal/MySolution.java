package com.hust.msolab.newmodel.JMetal;

import org.uma.jmetal.problem.PermutationProblem;
import org.uma.jmetal.solution.PermutationSolution;
import org.uma.jmetal.solution.impl.AbstractGenericSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySolution
        extends AbstractGenericSolution<Integer, PermutationProblem<?>>
        implements PermutationSolution<Integer> {


    public MySolution(PermutationProblem<?> problem) {
        super(problem) ;
        List<Integer> randomSequence = new ArrayList<>(problem.getPermutationLength());

        for (int j = 1; j <= problem.getPermutationLength(); j++) {
            randomSequence.add(j);
        }

        java.util.Collections.shuffle(randomSequence);

        for (int i = 0; i < getNumberOfVariables(); i++) {
            setVariableValue(i, randomSequence.get(i)) ;
        }
    }

    public MySolution(MySolution solution) {
        super(solution.problem) ;
        for (int i = 0; i < problem.getNumberOfObjectives(); i++) {
            setObjective(i, solution.getObjective(i)) ;
        }

        for (int i = 0; i < problem.getNumberOfVariables(); i++) {
            setVariableValue(i, solution.getVariableValue(i));
        }

        attributes = new HashMap<Object, Object>(solution.attributes) ;
    }

    @Override
    public String getVariableValueString(int index) {
        return getVariableValue(index).toString();
    }

    @Override
    public MySolution copy() {
        return new MySolution(this);
    }
}
