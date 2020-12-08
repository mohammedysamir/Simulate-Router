import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Device{
String Name,type;
String[] types={"PC","Mobile","Tablet","Laptop"};

Device(String N){
    Name=N;
    //get type randomly
    Random rand=new Random();
    int indexType=rand.nextInt(4); //select random number 0-(4-1)
    type=types[indexType];
}
public String getName() {
    return Name;
}
public String getType() {
    return type;
}

public void connect() throws IOException {
System.out.println("this device "+Name+"-"+type+" has been reconnected to router");
LoggingTime("this device "+Name+"-"+type+" has been reconnected to router");

}

public void disconnect() throws IOException {
System.out.println("this device "+Name+"-"+type+" has been disconnected to router");
LoggingTime("this device "+Name+"-"+type+" has been disconnected to router");
}

public void PerformActivity() throws IOException {
    System.out.println("this device "+Name+"-"+type+" performed some activities");
    LoggingTime("this device "+Name+"-"+type+" performed some activities");
}

private void LoggingTime(String record)throws IOException{
    LocalDateTime dateTime=LocalDateTime.now();
    DateTimeFormatter f=DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
    Writer.Write(record+" at "+f.format(dateTime));
}

}