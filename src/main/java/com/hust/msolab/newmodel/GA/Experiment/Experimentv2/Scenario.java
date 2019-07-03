package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import java.io.IOException;

/**
 * Abstract quy định cách thức viết một kịch bản để chạy thực nghiệm
 *
 * @author sondn on 07/05/2019
 */

public abstract class Scenario {
    abstract void initFixedValues();
    abstract void run(String dataFolder) throws IOException;
}
