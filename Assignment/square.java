import java.util.Scanner;

public class square{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        double num = sc.nextDouble();
        System.out.println("Square is: "+ num*num);
    }
}