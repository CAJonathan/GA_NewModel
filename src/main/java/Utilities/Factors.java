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
    public static int GA_CHOSEN_FITNESS_FUNCTION = 6;               // values: 1, 2, 3, 4, 5, 6
    public static int GA_CHOSEN_CROSSOVER_FUNCTION = 2;             // values: 1, 2, 3
    public static int GA_CHOSEN_MUTATION_FUNCTION = 3;              // values: 1, 2, 3, 4, 5
    public static int GA_CHOSEN_NATURAL_SELECTION_FUNCTION = 1;     // values: 1, 2

    // Choosing data scenarios
    public static String INPUT_FOLDER = "Data/";
    public static String OUTPUT_FOLDER = "Result3/";
    public static String DISTRIBUTION_ENERGY_PREFIX = "Uniform_distribution_energy/";
    public static String REMAINING_ENERGY_PREFIX = "Medium_energy/";
    public static String DISTRIBUTION_LOCATION_PREFIX = "uniform_distribution_location/";
    public static String SCENARIO_INDEX = "s1-";
    public static String SIZE = "30";
    public static String SENSOR_LOCATION_INDEX = "-near";
    // =================================================================================================





    // ======================================Never make any change unless you know exactly what you're going to do===========================================

    public static String PATH_TO_RESOURCE = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/";
    // Fixed factors in WRSN
    public static double WCE_V = 5;
    public static double WCE_U = 5;
    public static double WCE_P_MOVE = 1;
    public static double WCE_Emc = 40000;
    public static double SERVICE_STATION_X = 0;
    public static double SERVICE_STATION_Y = 0;
    public static double SENSOR_Emin = 540;
    public static double SENSOR_Emax = 8000;

    // =====================================================================================================================================================




    private static String INPUT_FILE_PATH;
    private static String OUTPUT_FILE_PATH;
    public static List<Double> REMAINING_ENERGIES;
    public static int NUM_OF_SENSORS;
    public static List<Double> P;

    public Factors(){
        String REMAINING_ENERGY_INDEX = "-" + REMAINING_ENERGY_PREFIX.split("_")[0].toLowerCase();
        String DISTRIBUTION_LOCATION_INDEX = Character.toString(DISTRIBUTION_LOCATION_PREFIX.toLowerCase().charAt(0));
        String FILE_NAME = DISTRIBUTION_ENERGY_PREFIX.contains("Normal") ?
                ((DISTRIBUTION_LOCATION_INDEX.equals("n") ? SCENARIO_INDEX : "") + DISTRIBUTION_LOCATION_INDEX + SIZE + REMAINING_ENERGY_INDEX)
                : (DISTRIBUTION_LOCATION_INDEX + SIZE + (DISTRIBUTION_LOCATION_INDEX.equals("n") ? SENSOR_LOCATION_INDEX : ""));
        String INPUT_FILE_NAME =  FILE_NAME + ".txt";
        String OUTPUT_FILE_NAME = FILE_NAME + "-result.txt";

        INPUT_FILE_PATH = PATH_TO_RESOURCE +
                Factors.INPUT_FOLDER +
                Factors.DISTRIBUTION_ENERGY_PREFIX +
                (Factors.DISTRIBUTION_ENERGY_PREFIX.contains("Normal") ? Factors.REMAINING_ENERGY_PREFIX : "") +
                Factors.DISTRIBUTION_LOCATION_PREFIX +
                INPUT_FILE_NAME;

        OUTPUT_FILE_PATH = PATH_TO_RESOURCE +
                Factors.OUTPUT_FOLDER +
                Factors.DISTRIBUTION_ENERGY_PREFIX +
                (Factors.DISTRIBUTION_ENERGY_PREFIX.contains("Normal") ? Factors.REMAINING_ENERGY_PREFIX : "") +
                Factors.DISTRIBUTION_LOCATION_PREFIX +
                OUTPUT_FILE_NAME;
    }

    public String inputFilePath(){
        return INPUT_FILE_PATH;
    }

    public String outputfilePath(){
        return OUTPUT_FILE_PATH;
    }
}
