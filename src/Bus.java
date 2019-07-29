public class Bus extends Thread {

    private String name;

    public Bus(String name){
        this.name = name;
    }

    public void depart(){
        System.out.println("The bus is departed!");
    }

    @Override
    public void run() {
        System.out.println("Bus "+name+" is Running");
    }
}
