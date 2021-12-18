import java.util.Scanner;

public class circleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius: ");
        double radii= sc.nextDouble();
        System.out.println("Area of circle is:"+ 3.14*(radii*radii));
    }
}
