package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.List;

public interface FitnessFunction{

    double execute(List<Integer> chromosome);
}
