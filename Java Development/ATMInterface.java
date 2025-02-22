import java.util.Scanner;
class Account {
    String AccountHolder;
    int Accountnumber;
    double Balance;

    Account (String name,int number,double balance){
        AccountHolder=name;
        Accountnumber=number;
        Balance=balance;
    }

    void deposit(double amount){
        if(amount> 0)
        {
            Balance += amount;
            System.out.println("Successfully deposited $" + amount);
        }
        else{
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount){
        if(amount > 0 && amount <= Balance)
        {
            Balance-=amount;
            System.out.println("Successfully withdrawn $" + amount);
        }
        else if(amount > Balance)
        {
            System.out.println("Insufficient funds or invalid amount.");
        }
        else {
            System.out.println("Invalid withdrawing amount.");
        }
    }

    void checkBalance(){
        System.out.println("Your balance: $" + Balance);
    }
}

public class ATMInterface{
public static void main(String[] args){
    Scanner in=new Scanner(System.in);
        System.out.println("ATM\n");
        System.out.print("Enter Account Holder Name: ");
        String name = in.nextLine();
        System.out.print("Enter Account Number: ");
        int num = in.nextInt();
        System.out.print("Enter Balance: ");
        double bal = in.nextDouble();
        Account acc = new Account(name, num, bal);

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option=in.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    acc.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = in.nextDouble();
                    acc.deposit(depositAmount);
                    break;
                case 3:
                    acc.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}