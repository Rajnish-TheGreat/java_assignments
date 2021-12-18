import java.util.Scanner;

public class si {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal, time and roi:");
        float p = sc.nextFloat();
        float t = sc.nextFloat();
        float rate = sc.nextFloat();
        System.out.println("Simple Interest is:" + (p*t*rate)/100);
    }
}
