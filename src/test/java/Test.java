import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileChannel.open(Paths.get("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/b.txt"), StandardOpenOption.WRITE)
                .truncate(0).close();
        try {
            FileReader fr = new FileReader("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/a.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/b.txt", true);
            String s;

            while ((s = br.readLine()) != null) { // read a line
                fw.write(s + "\n"); // write to output file
                fw.flush();
            }
            br.close();
            fw.close();
            System.out.println("file copied");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
