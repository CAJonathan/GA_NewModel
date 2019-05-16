package com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.ArrayList;

public interface MutationOperator {

    ArrayList<Integer> execute(ArrayList<Integer> chromosome);
}
