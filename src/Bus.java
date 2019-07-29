import java.util.concurrent.Semaphore;

public class Bus extends Thread {

    private int id;
    private Semaphore bus, allAboard, mutex;

    public Bus(int id, Semaphore bus, Semaphore allAboard, Semaphore mutex) {
        this.id = id;
        this.bus = bus;
        this.mutex = mutex;
        this.allAboard = allAboard;
    }

    public void depart() {
        System.out.println("The bus is departed!");
    }

    @Override
    public void run() {
        System.out.println("\nBus "+id+" arrived!");
        try {
            mutex.acquire();
            if (Rider.riders > 0){
                bus.release();
                allAboard.acquire();
            }
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
