import java.util.concurrent.Semaphore;

public class Rider extends Thread {

    private int id;
    public static int riders = 0;
    private Semaphore busSlots, allAboard, bus, mutex;

    public Rider(int id, Semaphore busSlots, Semaphore allAboard, Semaphore bus, Semaphore mutex) {
        this.id = id;
        this.busSlots = busSlots;
        this.allAboard = allAboard;
        this.bus = bus;
        this.mutex = mutex;
    }

    private void boardBus() {
        System.out.println("Rider " + id + " is boarded.");
    }

    public void run() {
        System.out.println("Rider " + id + " has came to the bus stop");
        try {
            System.out.println("Rider " + id + " try to acquire bus..\n");
            busSlots.acquire();
            mutex.acquire();
            riders++;
            mutex.release();
            bus.acquire();
            busSlots.release();

            boardBus();
            riders--;
            if (riders == 0) {
                allAboard.release();
            } else {
                bus.release();
            }

        } catch (InterruptedException e) {
            System.out.println("Failed to acquire!");
            e.printStackTrace();
        }
    }
}
