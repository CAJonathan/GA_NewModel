package com.hust.msolab.newmodel.INMA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import com.hust.msolab.newmodel.INMA.Framework;
import com.hust.msolab.newmodel.INMA.Utilities.INMAFileIO;
import org.javatuples.Pair;

import java.util.Map;

public class Scenario4 extends Scenario{

    @Override
    public TupProperties createProperties() {
        TupProperties properties = new TupProperties();
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n20-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n20-high-inmaresult.txt", 16383.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n30-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n30-high-inmaresult.txt", 16474.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n40-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n40-high-inmaresult.txt", 16469.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n70-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n70-high-inmaresult.txt", 16689.0);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n80-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n80-high-inmaresult.txt", 16720.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n90-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n90-high-inmaresult.txt", 16866.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s1-n100-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s1-n100-high-inmaresult.txt", 16979.5);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n20-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n20-high-inmaresult.txt", 16432.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n30-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n30-high-inmaresult.txt", 16577.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n40-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n40-high-inmaresult.txt", 16641.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n70-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n70-high-inmaresult.txt", 16923.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n80-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n80-high-inmaresult.txt", 17292.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n90-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n90-high-inmaresult.txt", 17430.5);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s2-n100-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s2-n100-high-inmaresult.txt", 17436.1);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n20-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n20-high-inmaresult.txt", 16557.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n30-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n30-high-inmaresult.txt", 16884.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n40-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n40-high-inmaresult.txt", 17033.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n70-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n70-high-inmaresult.txt", 17595.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n80-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n80-high-inmaresult.txt", 17557.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n90-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n90-high-inmaresult.txt", 17980.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/normal_distribution_location/s3-n100-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/normal_distribution_location/s3-n100-high-inmaresult.txt", 18292.9);





        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n20-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n20-medium-inmaresult.txt", 16401.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n30-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n30-medium-inmaresult.txt", 16418.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n40-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n40-medium-inmaresult.txt", 16509.5);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n70-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n70-medium-inmaresult.txt", 16727.0);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n80-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n80-medium-inmaresult.txt", 16753.0);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n90-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n90-medium-inmaresult.txt", 16820.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n100-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s1-n100-medium-inmaresult.txt", 16855.8);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n20-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n20-medium-inmaresult.txt", 16525.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n30-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n30-medium-inmaresult.txt", 16571.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n40-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n40-medium-inmaresult.txt", 16776.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n70-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n70-medium-inmaresult.txt", 17217.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n80-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n80-medium-inmaresult.txt", 17351.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n90-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n90-medium-inmaresult.txt", 17426.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n100-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s2-n100-medium-inmaresult.txt", 17641.7);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n20-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n20-medium-inmaresult.txt", 16551.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n30-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n30-medium-inmaresult.txt", 16891.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n40-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n40-medium-inmaresult.txt", 17028.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n70-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n70-medium-inmaresult.txt", 17597.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n80-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n80-medium-inmaresult.txt", 17528.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n90-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n90-medium-inmaresult.txt", 17668.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n100-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/normal_distribution_location/s3-n100-medium-inmaresult.txt", 18490.0);





        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n20-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n20-low-inmaresult.txt", 16400.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n30-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n30-low-inmaresult.txt", 16408.5);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n40-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n40-low-inmaresult.txt", 16468.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n70-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n70-low-inmaresult.txt", 16720.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n80-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n80-low-inmaresult.txt", 16778.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n90-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n90-low-inmaresult.txt", 16695.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n100-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s1-n100-low-inmaresult.txt", 16946.7);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n20-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n20-low-inmaresult.txt", 16526.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n30-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n30-low-inmaresult.txt", 16638.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n40-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n40-low-inmaresult.txt", 16702.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n70-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n70-low-inmaresult.txt", 17036.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n80-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n80-low-inmaresult.txt", 17254.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n90-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n90-low-inmaresult.txt", 17293.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n100-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s2-n100-low-inmaresult.txt", 17621.2);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n20-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n20-low-inmaresult.txt", 16589.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n30-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n30-low-inmaresult.txt", 16871.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n40-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n40-low-inmaresult.txt", 17057.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n70-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n70-low-inmaresult.txt", 17423.0);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n80-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n80-low-inmaresult.txt", 17968.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n90-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n90-low-inmaresult.txt", 18098.1);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n100-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/normal_distribution_location/s3-n100-low-inmaresult.txt", 18499.4);
        
        
        
        
        
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u20-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u20-high-inmaresult.txt", 16801.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u30-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u30-high-inmaresult.txt", 17285.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u40-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u40-high-inmaresult.txt", 17458.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u70-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u70-high-inmaresult.txt", 18730.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u80-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u80-high-inmaresult.txt", 19096.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u90-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u90-high-inmaresult.txt", 19561.5);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/High_energy/uniform_distribution_location/u100-high-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/High_energy/uniform_distribution_location/u100-high-inmaresult.txt", 19953.2);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u20-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u20-medium-inmaresult.txt", 16930.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u30-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u30-medium-inmaresult.txt", 17357.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u40-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u40-medium-inmaresult.txt", 17698.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u70-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u70-medium-inmaresult.txt", 18590.3);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u80-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u80-medium-inmaresult.txt", 18975.7);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u90-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u90-medium-inmaresult.txt", 19580.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Medium_energy/uniform_distribution_location/u100-medium-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Medium_energy/uniform_distribution_location/u100-medium-inmaresult.txt", 19837.4);

        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u20-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u20-low-inmaresult.txt", 17010.4);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u30-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u30-low-inmaresult.txt", 17249.9);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u40-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u40-low-inmaresult.txt", 18068.8);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u70-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u70-low-inmaresult.txt", 18538.2);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u80-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u80-low-inmaresult.txt", 18634.5);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u90-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u90-low-inmaresult.txt", 19335.6);
        properties.addProperty(Factors.INPUT_FOLDER + "/Normal_distribution_energy/Low_energy/uniform_distribution_location/u100-low-result.txt",
                Factors.OUTPUT_FOLDER + "Normal_distribution_energy/Low_energy/uniform_distribution_location/u100-low-inmaresult.txt", 19731.9);





        properties.addProperty(Factors.INPUT_FOLDER + "Grid/grid-n200-far-result.txt",
                Factors.OUTPUT_FOLDER + "Grid/grid-n200-far-inmaresult.txt", 24757.7);
        properties.addProperty(Factors.INPUT_FOLDER + "Grid/grid-n200-near-result.txt",
                Factors.OUTPUT_FOLDER + "Grid/grid-n200-near-inmaresult.txt", 24978.1);




        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n20-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n20-far-inmaresult.txt", 16766.4);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n30-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n30-far-inmaresult.txt", 16731.6);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n40-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n40-far-inmaresult.txt", 16893.1);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n70-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n70-far-inmaresult.txt", 17787.4);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n80-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n80-far-inmaresult.txt", 17620.8);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n90-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n90-far-inmaresult.txt", 17962.6);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n100-far-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n100-far-inmaresult.txt", 18490.7);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n20-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n20-near-inmaresult.txt", 16354.7);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n30-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n30-near-inmaresult.txt", 16466.7);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n40-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n40-near-inmaresult.txt", 16484.6);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n70-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n70-near-inmaresult.txt", 16784.4);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n80-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n80-near-inmaresult.txt", 16762.1);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n90-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n90-near-inmaresult.txt", 16834.9);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n100-near-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/normal_distribution_location/n100-near-inmaresult.txt", 16896.9);





        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u20-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u20-inmaresult.txt", 17053.8);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u30-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u30-inmaresult.txt", 17483.1);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u40-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u40-inmaresult.txt", 17437.6);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u70-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u70-inmaresult.txt", 18969.1);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u80-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u80-inmaresult.txt", 19179.3);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u90-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u90-inmaresult.txt", 19402.7);
        properties.addProperty(Factors.INPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u100-result.txt",
                Factors.OUTPUT_FOLDER + "Uniform_distribution_energy/uniform_distribution_location/u100-inmaresult.txt", 19871.1);





        properties.addProperty(Factors.INPUT_FOLDER + "Grid/grid-u200-far-result.txt",
                Factors.OUTPUT_FOLDER + "Grid/grid-u200-far-inmaresult.txt", 25276.6);
        properties.addProperty(Factors.INPUT_FOLDER + "Grid/grid-u200-near-result.txt",
                Factors.OUTPUT_FOLDER + "Grid/grid-u200-near-inmaresult.txt", 24654.7);




        return properties;
    }

    @Override
    public void run(Properties properties) {
        Utils.cloneDirectory(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER);
        Map<Pair<String, String>, Double> propMap = properties.getProperties();
        for(Map.Entry<Pair<String, String>, Double> kv : propMap.entrySet()){
            String inputFilePath = kv.getKey().getValue0();
                String outputFilePath = kv.getKey().getValue1();
                try{
                    System.out.println(inputFilePath);
                    INMAFileIO fileIO = new INMAFileIO();
                    Framework framework = new Framework(inputFilePath);
                    framework.solve();
                    fileIO.output(framework.getSchedule(), framework.getNumOfDeaths(), framework.getExecutionTime(), outputFilePath);
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }
}
