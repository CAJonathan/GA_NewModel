package com.hust.msolab.newmodel.INMA;

import com.hust.msolab.newmodel.GA.Utilities.Factors;

import java.io.IOException;

public class Experiment {

    public static void main(String[] args) throws IOException {
        Framework framework = new Framework();
        framework.run(Factors.INPUT_FILE_PATH);
    }
}
