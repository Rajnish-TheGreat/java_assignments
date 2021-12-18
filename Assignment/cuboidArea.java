import java.util.Scanner;

public class cuboidArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length: ");
        double len= sc.nextDouble();
        System.out.println("Enter Bredth: ");
        double bred= sc.nextDouble();
        System.out.println("Enter Height: ");
        double high= sc.nextDouble();
        System.out.println("Area of cuboid is:"+ 2*((len*bred)+(bred*high)+(high*len)));
    }
}
