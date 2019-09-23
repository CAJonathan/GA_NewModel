package com.hust.msolab.newmodel.GA.Experiment.Experimentv2;

import com.hust.msolab.newmodel.GA.Experiment.Experiment;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;

import java.io.File;
import java.io.IOException;

/**
 *  Class kịch bản chạy thực nghiệm: thay đổi năng lượng tố đa Emc của mỗi sensor,
 * giữ nguyên các tham số khác và chạy thực nghiệm trên tất cả các file trong folder
 * dữ liệu
 *
 * @author sondn on 07/05/2019
 */

public class Scenario3 extends Scenario {

    Double[] energys;

    public void initFixedValues(){
        energys = new Double[]{10000.0, 11000.0, 12000.0, 13000.0, 14000.0, 15000.0, 16000.0, 17000.0, 18000.0, 19000.0, 20000.0};
    }

    public void run(String dataFolder) throws IOException {
        File folder = new File(dataFolder);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String fileName = subFile.getName();
//                if(fileName.contains(100 + "-") || fileName.contains(100 + ".")){
                    String inputFilePath = subFile.getAbsolutePath();
                    String outputFilePath = inputFilePath.replace(Factors.INPUT_FOLDER, Factors.OUTPUT_FOLDER)
                            .replace(".", "-result.");
                    Utils.copyContent(inputFilePath, outputFilePath);
                    for(Double e : energys){
                        Factors.WCE_Emc = e;
                        Experiment.run(inputFilePath, outputFilePath);
                    }
//                }
            } else{
                run(dataFolder + "/" + subFile.getName());
            }
        }
    }
}
