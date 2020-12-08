import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {

    int value = 1;
    Queue<Device> queue = new LinkedList<>();

    Semaphore() {
        value = 1;
    }

    public synchronized void waiting(Device D) throws IOException, InterruptedException
        {
          value--;
          if(value<0)
          {
            queue.add(D);
            System.out.println("device "+D.getname()+"-"+D.getType()+" has arrived and waiting");
            D.LoggingTime("device "+D.getname()+"-"+D.getType()+" has arrived and waiting");
            wait();
           }
         }

    public synchronized void signal(Device D)
         {
           value++;
           if(value<=0)
           {
             queue.remove(D);
             notify();
           }
           
         }
   
}
