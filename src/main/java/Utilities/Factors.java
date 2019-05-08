package Utilities;

import java.util.List;

public class Factors {

    public static List<Double> REMAINING_ENERGIES;
    public static int NUM_OF_SENSORS;
    public static List<Double> P;

    // For genetic algorithm
    public static int GA_LOOP = 500;
    public static int GA_POPULATION_SIZE = 300;
    public static int GA_PARENTS_PAIR_SIZE = 100;

    // For crossover operators
    public static double GA_CROSSOVER_PROBABILITY = 0.5;
    public static double GA_CHANGE_CROSSOVER_OPERATION_PROBABILITY1 = 0.01;
    public static int GA_TOURNAMENT_SIZE = 5;

    // For mutation operators
    public static double GA_MUTATION_PROBABILITY = 0.1;
    public static double GA_CHANGE_MUTATION_OPERATION_PROBABILITY1 = 0.15;
    public static double GA_CHANGE_MUTATION_OPERATION_PROBABILITY2 = 0.15;

    // For fitness functions
    public static double ALPHA = 0.5;
    public static double K = 0.02;

    // Choosing GA operators in experimentation
    public static int GA_CHOSEN_FITNESS_FUNCTION = 3;               // values: 1, 2, 3
    public static int GA_CHOSEN_CROSSOVER_FUNCTION = 2;             // values: 1, 2, 3
    public static int GA_CHOSEN_MUTATION_FUNCTION = 3;              // values: 1, 2, 3, 4, 5
    public static int GA_CHOSEN_NATURAL_SELECTION_FUNCTION = 1;     // values: 1, 2



    // Determine data file and result file
    public static String INPUTFILE_PATH_TO_DATA_FOLDER = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data/";
    public static String OUTPUT_PATH_TO_RESULT_FOLDER = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/TestResult/";

    public static String DISTRIBUTION_ENERGY_PREFIX = "Normal_distribution_energy/";
    public static String REMAINING_ENERGY_PREFIX = "Low_energy/";
    public static String DISTRIBUTION_LOCATION_PREFIX = "normal_distribution_location/";

    public static String INPUTFILE_NAME = "s3-n70-low.txt";
    public static String OUTPUTFILE_NAME = "s3-n70-low-result.txt";



    // Fixed factors in WRSN
    public static double WCE_V = 5;
    public static double WCE_U = 5;
    public static double WCE_P_MOVE = 1;
    public static double SERVICE_STATION_X = 0;
    public static double SERVICE_STATION_Y = 0;

    public static double SENSOR_Emin = 540;
    public static double SENSOR_Emax = 8000;
}
