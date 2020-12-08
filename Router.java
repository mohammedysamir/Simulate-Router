import java.io.IOException;
import java.util.*;

public class Router {
    int maxdevice;
    Semaphore c;
    ArrayList<Device> devices = new ArrayList<Device>();

    Router(int m) {
        maxdevice = m;
    }

    public void connect(Device device) throws IOException, InterruptedException
 {
   c.waiting(device);
   if(devices.size()!=maxdevice){
     devices.add(device);
   }
 }
 public void disconnect(Device device){
   for(int i=0;i<devices.size();i++){
     if(devices.get(i)==device) devices.remove(i);
   }
   c.signal(device);
 }


}
