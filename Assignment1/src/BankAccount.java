import java.util.Scanner;

public class BankAccount {

    String firstName;
    String lastName;
    int accountId;
    double balance;
    Scanner in = new Scanner(System.in);


    public BankAccount() {
        this.firstName = "";
        this.lastName = "";
        this.accountId = 0;
        this.balance = 0;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public  void deposit(double depositAmount){
        balance = balance+depositAmount;
        System.out.println(balance);
    }

    public void withdrawal(double withdrawalAmount){
        balance = balance - withdrawalAmount;
        System.out.println(balance);
    }

    public void accountSummary(){
        System.out.println("First name" + firstName);
        System.out.println("Last name"+ lastName);
        System.out.println("Account id" + getAccountId());
        System.out.println("Current Balance" +
                "" + getBalance());
    }

    public void idVerification(){
        System.out.println("Please enter your first name");
        String custName = in.nextLine();
        setFirstName(custName);

        System.out.println("Pleas enter your last name");
        String custLastName = in.nextLine();
        setLastName(custLastName);

        System.out.println("Pleas enter your account id");
        int custAccountId = in.nextInt();
        setAccountId(custAccountId);
    }

    public static void main(String[] args){
        CheckingAccount userAccount = new CheckingAccount();

        Scanner in = new Scanner(System.in);
        int userChoice =-1 ;

        System.out.println("Please verify your identity");
        userAccount.idVerification();

        while(userChoice!= 0){
            System.out.println("What would you like to do? \n1. Deposit an amount \n2.Withdraw an amount " +
                    "\n3.Display Account summary");
            System.out.println("Please choose a number from the list or 0 to quit");
            userChoice = in.nextInt();

            if (userChoice == 1){
                double deposited;
                System.out.println("Please enter a deposit amount");
                deposited = in.nextDouble();
                userAccount.deposit(deposited);

            }else if(userChoice == 2){
                double withdrawn;
                System.out.println("Please enter a withdraw amount");
                withdrawn = in.nextDouble();
                userAccount.withdrawal(withdrawn);
                if(userAccount.getBalance()<0){
                    userAccount.overDraft();
                }
            }else if (userChoice == 3){
                userAccount.displayAccount();
            }else if (userChoice<0 || userChoice>3){
                System.out.println("Invalid Choice");
            }
        }

    }
}
