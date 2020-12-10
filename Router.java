import java.io.IOException;
import java.util.*;

public class Router {
    int maxdevice;
    Semaphore c;
    ArrayList<Device> devices = new ArrayList<Device>();

    Router(int m) {
        maxdevice = m;
        c = new Semaphore(maxdevice);
    }

    public void connect(Device device) throws IOException, InterruptedException {
        c.waiting(device);
    }

    public void disconnect(Device device) {
        int i = devices.indexOf(device);
        if(i>-1)devices.remove(i);
        c.signal(device);
    }

    public void SetArray(ArrayList<Device> d) {
        devices = d;
    }

    public void run() {
        for (int i = 0; i < devices.size(); i++)
            (new Thread(new Device(devices.get(i), this))).start();
    }

}
