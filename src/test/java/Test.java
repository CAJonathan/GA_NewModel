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

    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("com.hust.msolab.newmodel.GA.Utilities.Factors");
        Field f = cls.getField("GA_LOOP");
    }

}
