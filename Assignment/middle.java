import java.util.Scanner;

public class middle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a 3 digit number: ");
        int num = sc.nextInt();
        int temp = num/10;
        int mid = temp%10;
        System.out.println(mid);
    }
}
