package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.ArrayList;

public interface FitnessFunction{
    double execute(ArrayList<Integer> chromosome);
}
