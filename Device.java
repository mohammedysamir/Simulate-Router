import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Device extends Thread {
    String Name, type;
    String[] types = { "PC", "Mobile", "Tablet", "Laptop" };

    Device(String N) {
        Name = N;
        // get type randomly
        Random rand = new Random();
        int indexType = rand.nextInt(4); // select random number 0-(4-1)
        type = types[indexType];
    }

    public String getname() {
        return Name;
    }

    public String getType() {
        return type;
    }

    public void connect() throws IOException {
        System.out.println("this device " + Name + "-" + type + " has been reconnected to router");
        LoggingTime("this device " + Name + "-" + type + " has been reconnected to router");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws IOException {
        System.out.println("this device " + Name + "-" + type + " has been disconnected to router");
        LoggingTime("this device " + Name + "-" + type + " has been disconnected to router");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void PerformActivity() throws IOException {
        System.out.println("this device " + Name + "-" + type + " performed some activities");
        LoggingTime("this device " + Name + "-" + type + " performed some activities");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void LoggingTime(String record) throws IOException {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
        Writer.Write(record + " at " + f.format(dateTime));
    }

    public void run() {
        try {
            connect();
            PerformActivity();
            disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}