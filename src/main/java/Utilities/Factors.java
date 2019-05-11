package Utilities;

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
    public static double K = 0.02;

    // Choosing GA operators in experimentation
    public static int GA_CHOSEN_FITNESS_FUNCTION = 4;               // values: 1, 2, 3, 4
    public static int GA_CHOSEN_CROSSOVER_FUNCTION = 2;             // values: 1, 2, 3
    public static int GA_CHOSEN_MUTATION_FUNCTION = 3;              // values: 1, 2, 3, 4, 5
    public static int GA_CHOSEN_NATURAL_SELECTION_FUNCTION = 1;     // values: 1, 2

    // Choosing data scenarios
    public static String INPUT_FOLDER = "Data/";
    public static String OUTPUT_FOLDER = "TestResult/";
    public static String DISTRIBUTION_ENERGY_PREFIX = "Normal_distribution_energy/";
    public static String REMAINING_ENERGY_PREFIX = "High_energy/";
    public static String DISTRIBUTION_LOCATION_PREFIX = "normal_distribution_location/";
    private static String SCENARIO_INDEX = "s3-";
    private static String SIZE = "30";
    private static String SENSOR_LOCATION_INDEX = "-far";
    // =================================================================================================





    // ======================================Never make any change unless you know exactly what you're going to do===========================================
    public static List<Double> REMAINING_ENERGIES;
    public static int NUM_OF_SENSORS;
    public static List<Double> P;

    // Determine data file and result file
    public static String PATH_TO_RESOURCE = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/";
    private static String DISTRIBUTION_LOCATION_INDEX = Character.toString(DISTRIBUTION_LOCATION_PREFIX.toLowerCase().charAt(0));
    private static String REMAINING_ENERGY_INDEX = "-" + REMAINING_ENERGY_PREFIX.split("_")[0].toLowerCase();
    private static String FILE_NAME = DISTRIBUTION_LOCATION_INDEX.equals("n") ?
            SCENARIO_INDEX + DISTRIBUTION_LOCATION_INDEX + SIZE + REMAINING_ENERGY_INDEX
            : DISTRIBUTION_LOCATION_INDEX + SIZE + SENSOR_LOCATION_INDEX;
    public static String INPUT_FILE_NAME =  FILE_NAME + ".txt";
    public static String OUTPUT_FILE_NAME = FILE_NAME + "-result.txt";

    // Fixed factors in WRSN
    public static double WCE_V = 5;
    public static double WCE_U = 5;
    public static double WCE_P_MOVE = 1;
    public static double SERVICE_STATION_X = 0;
    public static double SERVICE_STATION_Y = 0;
    public static double SENSOR_Emin = 540;
    public static double SENSOR_Emax = 8000;
    // =====================================================================================================================================================
}
