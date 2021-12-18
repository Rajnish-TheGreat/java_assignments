abstract class vehicle{
    String color;
    String model;
    
    vehicle(String color, String model){
        this.color = color;
        this.model = model;
    }
    
    abstract void drive();
    abstract void park();
    
    void stop(){
        System.out.println("Vehicle is in Stop mode");
    }
}

abstract class fourWheeler extends vehicle {
    int seats;
    public fourWheeler(String color, String model, int seats) {
        super(color, model);
        this.seats = seats;
    }
    abstract void drive();
    abstract void park();
    @Override
    void stop(){
        System.out.println("Four Wheeler is in stop mode");
    }
    void start(){
        System.out.println("Four wheeler is in start mode");
    }
}

class twoWheeler extends vehicle {
    int seats;
    public twoWheeler(String color, String model) {
        super(color, model);
    }
    void drive(){
        System.out.println("Four Wheeler is in drive mode");
    }
    void park(){
        System.out.println("Four Wheeler is in park mode");
    }
    @Override
    void stop(){
        System.out.println("Four Wheeler is in stop mode");
    }
    void start(){
        System.out.println("Four wheeler is in start mode");
    }
}

class car extends fourWheeler {
    String company;
    public car(String color, String model, int seats, String company) {
        super(color, model, seats);
        this.company = company;
    }
    @Override
    void drive() {
        System.out.println("Car is in drive mode");
    }
    @Override
    void park() {
        System.out.println("Car is in park mode");
    }
    @Override
    void stop(){
        System.out.println("Car is in stop mode");
    }
    @Override
    void start(){
        System.out.println("Car is in start mode");
    }
}

class bike extends twoWheeler {
    String company;
    public bike(String color, String model, String company) {
        super(color, model);
        this.company = company;
    }
    @Override
    void drive(){
        System.out.println("BIKE is in drive mode");
    }
    @Override
    void park(){
        System.out.println("BIKE is in park mode");
    }
    @Override
    void stop(){
        System.out.println("BIKE is in stop mode");
    }
    @Override
    void start(){
        System.out.println("BIKE is in start mode");
    }
}

public class abstractFunction {
    public static void main(String[] args) {
        vehicle v1 = new car("red","teslaX",4,"tesla");
        v1.drive();
        // v1.start();
        v1.stop();
        v1.park();
        twoWheeler v2 = new twoWheeler("red", "activa4G");
        v2.drive();
        v2.start();
        v2.stop();
        v2.park();
        car v3 = new car("black", "honda city", 4, "honda");
        v3.drive();
        v3.start();
        v3.stop();
        v3.park();
        bike v4 = new bike("color", "model", "company");
        v4.drive();
        v4.start();
        v4.stop();
        v4.park();
    }
}