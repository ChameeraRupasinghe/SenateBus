import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Senate Bus---\n");

        float busArriveMeanTime = 20 * 60f * 1000;
        float riderArrivalMeanTime = 30f * 1000;

        Semaphore busSlots = new Semaphore(50);
        Semaphore allAboard = new Semaphore(0);
        Semaphore bus = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        BusGenerator busGenerator = new BusGenerator(bus, allAboard, mutex, busArriveMeanTime);
        RiderGenerator riderGenerator = new RiderGenerator(busSlots, allAboard, bus, mutex, riderArrivalMeanTime);

        busGenerator.start();
        riderGenerator.start();
    }
}
