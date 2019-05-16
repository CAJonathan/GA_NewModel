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
        String sourcePath = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Result/ResultTest";
        executeFile(sourcePath);
    }

    private static void executeFile(String folder){
        File f = new File(folder);
        for(File subFile : f.listFiles()){
            if(subFile.isFile()){
                System.out.println(subFile.getName());
            } else{
                executeFile(folder + "/" + subFile.getName());
            }
        }
    }
}
