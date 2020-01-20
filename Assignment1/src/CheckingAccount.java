public class CheckingAccount extends BankAccount {
    double interestRate;
    double gain;
    double overDraftFee = 30;

    public void overDraft(){
        System.out.println("Your current balance of " + getBalance() + " is negative");
        System.out.println("Your overdraft penalty is " + overDraftFee + "dollars");
    }

    public void displayAccount(){
        super.accountSummary();

        if (getBalance()>0 &&getBalance()<10000){
            interestRate = 0.01;
            gain = getBalance()*interestRate;
            System.out.println("Your interest rate is 1% and you're gaining a yearly amount of " + gain);
        }else if (getBalance()>10000){
            interestRate = 0.02;
            gain = getBalance()*interestRate;
            System.out.println("Your interest rate is 2% and you're gaining a yearly amount of " + gain);
        }else if(getBalance()<0){
            overDraft();
        }



    }

}
