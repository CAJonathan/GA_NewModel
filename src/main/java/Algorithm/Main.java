package Algorithm;

import Algorithm.Algorithm;
import Utilities.Factors;

import java.io.IOException;

public class Main {
    public static double [][] distances;

    public static void main(String[] args) throws IOException{
        Factors factors = new Factors();
        Algorithm ag = new Algorithm(factors);
        ag.solve();
    }
}
