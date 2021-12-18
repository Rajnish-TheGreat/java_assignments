import java.util.Scanner;

class farhen{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter temperature(in F): ");
        double temp=sc.nextDouble();
        System.out.println("Temperature(in C) is:" + ((5*temp)-160)/9);
    }
}