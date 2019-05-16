import java.io.*;

public class Test {
    private static String sourcePath = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Data";
    private static String destinationPath = "/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Result/ResultTest";

    public static void main(String[] args) throws IOException {

        clone(sourcePath, sourcePath, destinationPath);
    }

    private static void clone(String current, String src, String des) throws IOException{
        File folder = new File(current);
        for(File subFile : folder.listFiles()){
            if(subFile.isFile()){
                String directory = subFile.getParent();
                directory = directory.replace(src, des);
                File f = new File(directory);
                if(!f.exists()){
                    f.mkdirs();
                }
            } else{
                clone(subFile.getAbsolutePath(), src, des);
            }
        }
    }


}
