import java.util.Scanner;

class Employee {
    String name;
    int hours_week;
    int rate;
    int fed_tax;
    float fedTax;
    int state_tax;
    float stateTax;
    int totalPay;

    Employee() {
        System.out.println("Default Payroll is 0 for all employee");
    }

    Employee(String name, int hours_week, int rate, int fed_tax, int state_tax) {
        this.name = name;
        this.hours_week = hours_week;
        this.rate = rate;
        this.fed_tax = fed_tax;
        this.state_tax = state_tax;
    }

    void calTax() {
        fedTax = (4 * fed_tax * hours_week * rate) / 100;
        stateTax = (4 * state_tax * hours_week * rate) / 100;
        totalPay = (4 * hours_week * rate) - (int)(fedTax + stateTax);
    }

    void display() {
        System.out.print(
                name + "\t" + hours_week + "\t" + rate + "\t" + fedTax + "\t" + stateTax + "\t" + totalPay + "\n");
    }
}

public class payRoll {
    public static void main(String[] args) {
        String name;
        int hours_week, rate, fed_tax, state_tax;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employee: ");
        int num = sc.nextInt();
        Employee []emp = new Employee[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Employee"+(i+1)+" name: ");
            name = sc.next();
            System.out.print("\nEmployee"+(i+1)+" hours: ");
            hours_week = sc.nextInt();
            System.out.print("\nEmployee"+(i+1)+" Rate: ");
            rate = sc.nextInt();
            System.out.print("\nCGST: ");
            fed_tax = sc.nextInt();
            System.out.print("\nSGST: ");
            state_tax = sc.nextInt();
            emp[i] = new Employee(name, hours_week, rate, fed_tax, state_tax);
            emp[i].calTax();
        }
        System.out.print("\nName \tHours \tPayRate \tCGST \tSGST \tNet Income\n");
        for (int i = 0; i < num; i++) {
            emp[i].display();
        }
    }
}
