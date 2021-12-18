import java.util.Scanner;

class Account{
    int acc_id;
    String acc_name;
    double balance;
    String bank_name = "Harshad Mehta Bank";
    
    Account(){
        acc_id = 0;
        acc_name = "Rajnish";
        balance = 501;
        
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


class savingAccount extends Account{
    final double interestRate = 3;
    double interest;
    
    savingAccount(int acc_id, String acc_name, double balance){
        super(acc_id,acc_name,balance);
    }
    savingAccount(){
        super();
    }
    public double calculateInterest(){
        interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Credited interest amount: " + interest);
        return interest;
    }
    //override deposite and tostring
    public String toString(){
        return super.toString() + "\nInterest Rate" + interestRate + "\nInterest Amount" + interest;
    }
}

class currentAccount extends Account{
    final double overdraftLimit = 3000;
    //override withdraw 
    currentAccount() {
        super();
    }
    currentAccount(int acc_id, String acc_name, double balance){
        super(acc_id,acc_name,balance);
    }
    public void withdraw(double amount){
        double penalty;
        if(balance <= 500.0){
            penalty = 50.0;
            System.out.println("Due to maintaining balance lower than 500, you are charged 50 rupees");
        }
        else
            penalty = 0.0;
        if (balance + overdraftLimit >= amount){
            balance = balance - amount-penalty;
            System.out.print("\nWithdrawn: " + amount);
            System.out.println("\nUpdated balance: " + balance);
        }
        else
            System.out.println("Insufficient funds");
    }
}

public class bankAccountInheritance {
    
    static void menuFunction(Account a[]) {
        String newName;
        int acc_id, choice;
        double balance;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nMenu");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: See all users");
            System.out.println("4: Update User Name");
            System.out.println("5: Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter Account Id: ");
                    acc_id = sc.nextInt();
                    for (int i = 0; i < a.length; i++) {
                        if (acc_id == a[i].acc_id) {
                            System.out.print("\nEnter Amount to deposit: ");
                            balance = sc.nextDouble();
                            a[i].deposit(balance);
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nEnter Account Id: ");
                    acc_id = sc.nextInt();
                    for (int i = 0; i < a.length; i++) {
                        if (acc_id == a[i].acc_id) {
                            System.out.print("\nEnter Amount to withdraw: ");
                            balance = sc.nextDouble();
                            a[i].withdraw(balance);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i].toString());
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Id : ");
                    acc_id = sc.nextInt();
                    for (int i = 0; i < a.length; i++) {
                        if (acc_id == a[i].acc_id) {
                            System.out.print("\nEnter new bank name: ");
                            newName = sc.next();
                            a[i].changeBankName(newName);
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
            }
        } while (choice != 5);
    }
    public static void main(String[] args) {
        String acc_name;
        int acc_id, size, accType;
        double balance;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu\n1: Saving account\n2: Current Account\n3: Exit");
            System.out.print("Enter your choice: ");
            accType = sc.nextInt();
            switch (accType) {
                case 1:
                    System.out.print("\nEnter number of customers : ");
                    size = sc.nextInt();
                    savingAccount savingAccount[] = new savingAccount[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("\nEnter customer name: ");
                        acc_name = sc.next();
                        System.out.print("\nEnter ID: ");
                        acc_id = sc.nextInt();
                        System.out.print("\nEnter opening account balance: ");
                        balance = sc.nextDouble();
                        savingAccount[i] = new savingAccount(acc_id, acc_name, balance);
                    }
                    menuFunction(savingAccount);
                    break;
                case 2:
                    System.out.print("\nEnter number of customers : ");
                    size = sc.nextInt();
                    currentAccount currentAccount[] = new currentAccount[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("\nEnter your name : ");
                        acc_name = sc.next();
                        System.out.print("\nEnter your ID: ");
                        acc_id = sc.nextInt();
                        System.out.print("\nEnter opening account balance: ");
                        balance = sc.nextDouble();
                        currentAccount[i] = new currentAccount(acc_id, acc_name, balance);
                    }
                    menuFunction(currentAccount);
                    break;
                case 3:
                    break;
                default:
                System.out.println("Invalid Choice!!!");
            }
        } while (accType != 3);

        sc.close(); // close the scanner
    }
}
