import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Semaphore busSlots = new Semaphore(50);
        Semaphore allAboard = new Semaphore(1);
        Semaphore bus = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);



        Rider r1 = new Rider(1, busSlots, allAboard, bus, mutex);
        Rider r2 = new Rider(2, busSlots, allAboard, bus, mutex);
        Bus b1 = new Bus(1, bus, allAboard, mutex);

        b1.start();
        r1.start();
        r2.start();
    }
}
