package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.List;

public interface MutationOperator {

    List<Integer> execute(List<Integer> chromosome);
}
