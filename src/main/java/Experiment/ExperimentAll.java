package Experiment;

import Utilities.Factors;
import Utilities.Utils;

public class ExperimentAll {
    private static String[] distributionEnergyPrefixs = { "Normal_distribution_energy/", "Uniform_distribution_energy/"};
    private static String[] remainingEnergyPrefixs = {"High_energy/", "Medium_energy/", "Low_energy/"};
    private static String[] distributionLocationPrefixs = {"uniform_distribution_location/", "normal_distribution_location/"};
    private static String[] scenariosIndexs = {"s1-", "s2-", "s3-"};
    private static String[] sizes = {"20", "30", "40", "70", "80", "90", "100"};
    private static String[] sensorLocationIndexs = {"-far", "-near"};

    private static int LOOP = 30;

    public static void main(String[] args){
        Utils.createDataBin("Result3");
        Factors.OUTPUT_FOLDER = "Result3/";

        for(String distributionEnergyPrefix : distributionEnergyPrefixs){
            if(distributionEnergyPrefix.contains("Normal_distribution_energy")){
                for(String remainingEnergyPrefix : remainingEnergyPrefixs){
                    for(String distributionLocationPrefix : distributionLocationPrefixs){
                        if(distributionLocationPrefix.contains("normal")){
                            for(String scenariosIndex : scenariosIndexs){
                                for(String size : sizes){
                                    Factors.DISTRIBUTION_ENERGY_PREFIX = distributionEnergyPrefix;
                                    Factors.REMAINING_ENERGY_PREFIX = remainingEnergyPrefix;
                                    Factors.DISTRIBUTION_LOCATION_PREFIX = distributionLocationPrefix;
                                    Factors.SCENARIO_INDEX = scenariosIndex;
                                    Factors.SIZE = size;

                                    Experiment.run();
                                }
                            }
                        } else{
                            for(String size : sizes){
                                Factors.DISTRIBUTION_ENERGY_PREFIX = distributionEnergyPrefix;
                                Factors.REMAINING_ENERGY_PREFIX = remainingEnergyPrefix;
                                Factors.DISTRIBUTION_LOCATION_PREFIX = distributionLocationPrefix;
                                Factors.SIZE = size;

                                Experiment.run();
                            }
                        }
                    }
                }
            }
            else{
                for(String distributionLocationPrefix : distributionLocationPrefixs) {
                    if(distributionLocationPrefix.contains("normal")){
                        for (String sensorLocationIndex : sensorLocationIndexs) {
                            for (String size : sizes) {
                                Factors.DISTRIBUTION_ENERGY_PREFIX = distributionEnergyPrefix;
                                Factors.SENSOR_LOCATION_INDEX = sensorLocationIndex;
                                Factors.DISTRIBUTION_LOCATION_PREFIX = distributionLocationPrefix;
                                Factors.SIZE = size;

                                Experiment.run();
                            }
                        }
                    } else{
                        for (String size : sizes) {
                            Factors.DISTRIBUTION_ENERGY_PREFIX = distributionEnergyPrefix;
                            Factors.DISTRIBUTION_LOCATION_PREFIX = distributionLocationPrefix;
                            Factors.SIZE = size;

                            Experiment.run();
                        }
                    }
                }
            }

        }
    }

}
