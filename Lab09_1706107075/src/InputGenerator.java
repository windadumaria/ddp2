import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class InputGenerator {

    public static void main (String[] args) {
        String jalan="";
        String kelurahan= "";

        jalan = Long.toHexString(Double.doubleToLongBits(Math.random()));
        System.out.println("jalan="+jalan);
    }

    private static void cetakOutputFile(String filename, List<String> inputs) throws FileNotFoundException {
        PrintWriter out = new	PrintWriter("/Users/windadumarias/IdeaProjects/Lab09_1706107075/src/"+filename+".txt");
        for(String input:inputs){
            out.println(input);
        }
        out.close();
    }
}
