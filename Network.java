import java.io.IOException;
import java.util.*;

public class Network {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String input;
        ArrayList<Device> device = new ArrayList<Device>();
        System.out.println("*Welcome to RouterSim*");

        int NumberofUsers, MaxNumber;

        System.out.println("Enter Maximum number of allowed devices for router");
        MaxNumber = scan.nextInt();

        System.out.println("Enter Number of devices to connect");
        NumberofUsers = scan.nextInt();
        scan.nextLine();
        Router r = new Router(MaxNumber);

        for (int i = 0; i < NumberofUsers; i++) {
            System.out.print("Enter device name :");
            input = scan.nextLine();
            Device D = new Device(input, r);
            device.add(D);
        }

        r.SetArray(device);
        r.run();
        scan.close();
    }
}