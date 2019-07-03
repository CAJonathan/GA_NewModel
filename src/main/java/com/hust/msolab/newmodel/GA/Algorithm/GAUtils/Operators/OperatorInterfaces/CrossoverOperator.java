package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

/**
 *  Interface đại diện cho các toán tử lai ghép. Mỗi toán tử lai ghép mới được viết cần phải
 * implements interface này
 * @aythor sondn on 30/04/2019
 */

public interface CrossoverOperator{

    Pair<Individual, Individual> execute(Individual indDad, Individual indMom);
}
