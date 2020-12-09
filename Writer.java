import java.io.FileWriter;
import java.io.IOException;
//class to write log text into Log file
public class Writer {
    static String log = "Log.txt";
    static String out="";
    static void Write(String text) throws IOException {
        out+=text+System.lineSeparator();
        FileWriter output=new FileWriter(log);
        output.write(out);
        output.close();
    }
}

