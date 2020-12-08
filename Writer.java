import java.io.FileWriter;
import java.io.IOException;
//class to write log text into Log file
public class Writer {
    static String log = "Log.txt";
    static void Write(String text) throws IOException {
        FileWriter output = new FileWriter(log);
        output.write(text);
        output.close();
    }
}

