public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Bus b1 = new Bus("1");
        Bus b2 = new Bus("2");
        Bus b3 = new Bus("3");

        b1.start();
        b2.start();
        b3.start();

    }
}
