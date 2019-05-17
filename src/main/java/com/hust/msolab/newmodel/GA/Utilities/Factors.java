package com.hust.msolab.newmodel.GA.Utilities;

import java.util.List;

public class Factors {


    // ================================Only change for experiment=======================================
    // For genetic algorithm
    public static int GA_LOOP = 500;
    public static int GA_POPULATION_SIZE = 200;

    // For crossover operators
    public static double GA_CROSSOVER_PROBABILITY = 0.5;
    public static double GA_CHANGE_CROSSOVER_OPERATION_PROBABILITY1 = 0.01;
    public static int GA_TOURNAMENT_SIZE = 5;
    public static int GA_PARENTS_PAIR_SIZE = 100;

    // For mutation operators
    public static double GA_MUTATION_PROBABILITY = 0.1;
    public static double GA_CHANGE_MUTATION_OPERATION_PROBABILITY1 = 0.15;
    public static double GA_CHANGE_MUTATION_OPERATION_PROBABILITY2 = 0.15;

    // For fitness functions
    public static double ALPHA = 0.5;
    public static double K = 0.01;

    // Choosing GA fitness function and operators
    public static int GA_CHOSEN_FITNESS_FUNCTION = 7;               // values: 1, 2, 3, 4, 5, 6, 7
    public static int GA_CHOSEN_CROSSOVER_FUNCTION = 2;             // values: 1, 2, 3
    public static int GA_CHOSEN_MUTATION_FUNCTION = 3;              // values: 1, 2, 3
    public static int GA_CHOSEN_NATURAL_SELECTION_FUNCTION = 1;     // values: 1, 2
    public static int GA_CHOSEN_PARENTS_SELECTION_FUNCTION = 1;     // values: 1

    // Choosing data file for all data experiment
    public static String INPUT_FOLDER = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data";
    public static String OUTPUT_FOLDER = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Result/Result3";

    // Choosing data file for single experiment
    public static String INPUT_FILE_PATH = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data/Uniform_distribution_energy/uniform_distribution_location/u70.txt";
    public static String OUTPUT_FILE_PATH = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data/Uniform_distribution_energy/uniform_distribution_location/u70-result.txt";

    // Jmetal
    public static int JMETAL_NUM_OF_SENSORS = 70;
    public static String JMETAL_OUTPUT_FOLDER = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/JMetal-Result";
    // =================================================================================================



    // ======================================Never make any change unless you know exactly what you're going to do===========================================

    // Fixed factors in WRSN
    public static double WCE_V = 5;
    public static double WCE_U = 5;
    public static double WCE_P_MOVE = 1;
    public static double WCE_Emc = 40000;
    public static double SERVICE_STATION_X = 0;
    public static double SERVICE_STATION_Y = 0;
    public static double SENSOR_Emin = 540;
    public static double SENSOR_Emax = 8000;

    // Store data scenario
    public static List<Double> REMAINING_ENERGIES;
    public static int NUM_OF_SENSORS;
    public static List<Double> P;
    public static double[][] distances;
    // =======================================================================================================================================================
}
