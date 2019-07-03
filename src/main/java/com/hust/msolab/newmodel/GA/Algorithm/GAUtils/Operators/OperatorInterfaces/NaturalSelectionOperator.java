package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import com.hust.msolab.newmodel.GA.Algorithm.Individual;

import java.util.List;

/**
 *  Interface đại diện cho các toán tử chọn lọc tự nhiên. Mỗi toán tử chọn lọc tự nhiên được viết ra
 * cần phải implements interface này
 *
 * @author sondn on 30/04/2019
 */

public interface NaturalSelectionOperator {

    List<Individual> execute(List<Individual> individuals);
}
