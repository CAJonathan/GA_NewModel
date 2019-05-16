import com.hust.msolab.newmodel.Utilities.Factors;
import com.hust.msolab.newmodel.Utilities.IOParser;
import com.sun.jmx.snmp.internal.SnmpSubSystem;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {
        String sourcePath = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data/Uniform_distribution_energy/uniform_distribution_location/u30.txt";

        String outputFilePath = sourcePath.replace("Data", "Result/" + Factors.OUTPUT_FOLDER_NAME).replace(".", "-result.");
        System.out.println(outputFilePath);
    }
}
