import com.hust.msolab.newmodel.GA.Utilities.Factors;
import com.hust.msolab.newmodel.GA.Utilities.Utils;
import org.javatuples.Pair;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException{
        long start = System.nanoTime();
        for(int i=-10000;i<10;i++) {
            // do test
        }
        long time = System.nanoTime() - start;
        System.out.println(time / 1000.0);
    }

}
