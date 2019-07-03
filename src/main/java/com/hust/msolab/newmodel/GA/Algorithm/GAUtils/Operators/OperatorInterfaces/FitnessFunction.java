package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.List;

/**
 *  Interface đại diện cho lớp các hàm fitness. Mỗi hàm fitness được viết ra đều phải
 * implements interface này
 *
 * @author sondn on 30/04/2019
 */

public interface FitnessFunction{

    double execute(List<Integer> chromosome);
}
