package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces;

import java.util.List;

/**
 *  Interface đại diện cho các toán tử đột biến. Mỗi toán tử mới được viết ra cần phải
 * implements interface này
 *
 * @author sondn on 30/04/2019
 */

public interface MutationOperator {

    List<Integer> execute(List<Integer> chromosome);
}
