package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.util.List;

/**
 *  Interface đại diện cho các toán tử chọn lọc cha mẹ. Mỗi toán tử được viết ra
 * cần phải implements interface này
 *
 * @author sondn on 30/04/2018
 */

public interface ParentsSelectionOperator {

    List<Pair<Individual, Individual>> execute(int numOfPair, List<Individual> individuals);
}
