import java.util.Scanner;
import java.util.jar.Attributes.Name;

class Account{
    private int acc_id;
    private String acc_name;
    private double balance;
    static String bank_name = "Harshad Mehta Bank";
    
    Account(){
        acc_id = 0;
        acc_name = "Rajnish";
        balance = 0;
        
    }

    Account(int acc_id, String acc_name, double balance){
        this.acc_id = acc_id;
        this.acc_name = acc_name;
        this.balance = balance;
    }

    public void withdraw(double amount){
        double penalty;
        if(balance <= 500.0){
            penalty = 50.0;
            System.out.println("Due to maintaining balance lower than 500, you are charged 50 rupees");
        }
        else
            penalty = 0.0;
        if (balance >= amount)
            balance -= amount-penalty;
        else
            System.out.println("Insufficient funds");
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }

    public void print(){
        System.out.println("Account ID: "+acc_id +"\nHolder Name: " + acc_name +"\nBalance: "+ balance + "\nBank Name: " + bank_name);
        System.out.println("");
    }

    public void changeBankName(String newName){
        bank_name = newName;
    }

    public String toString(){
        return "Account ID: "+acc_id +"\nHolder Name: " + acc_name +"\nBalance: "+ balance + "\nBank Name: " + bank_name;
    }
}




public class bankAccount{
    public static void main(String[] args) {
        String custName,bankName;
        // int id, balance, debit_amount, credit_amount;
        int choice;
        Account a1 = new Account(1,"Rajnish",10000);
        
        a1.print();
        a1.withdraw(5000);
        a1.print();
        a1.deposit(8000);
        a1.print();
        a1.changeBankName("SBI");
        System.out.println(a1);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nCustomer name: ");
        custName = sc.next();
        System.out.print("Customer ID: ");
        int id = sc.nextInt();
        System.out.print("Balance: ");
        double balance = sc.nextDouble();
        Account a2 = new Account(id, custName, balance);
        a2.print();
        do{
            System.out.print("\nMenu:");
            System.out.print("\n1.Deposit \n2.withdraw \n3.Change Bank \n4.Exit \nEnter your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter Amount to deposit: ");
                    double debit_amount= sc.nextDouble();
                    a2.deposit(debit_amount);
                    a2.getBalance();
                    break;
                case 2:
                    System.out.print("\nEnter Amount to withdraw: ");
                    double credit_amount= sc.nextDouble();
                    a2.withdraw(credit_amount);
                    a2.getBalance();
                    break;
                case 3:
                    System.out.print("\nEnter new bank name: ");
                    bankName= sc.next();
                    a2.changeBankName(bankName);
                    System.out.println(a2);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        }while(choice!=4);
    }
}