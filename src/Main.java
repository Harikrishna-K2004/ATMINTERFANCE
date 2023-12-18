import java.util.*;
class ATMCLASS {
    protected double accountbalance=0 ;
    public double balance  ;

    public void setAccountBalance(int acc) {
        balance = acc;
        accountbalance += balance;
    }

}
class userbankaccount extends ATMCLASS{
    public double withdrawamount;
    public double depositamount;
    public double remainingamount;
    public void withdraw(double amount1){
        withdrawamount = amount1;
        if(withdrawamount  <= accountbalance){
            remainingamount = accountbalance - withdrawamount;
            System.out.println("    Congratulations, your transaction of $"+withdrawamount+" is successful.");
            accountbalance = accountbalance - withdrawamount;
            System.out.println("    Your remaining Account Balance is : $"+ accountbalance);
        }
        else if(withdrawamount > accountbalance){
            System.out.println("    Insufficient Balance for transaction, Please select the amount within $"+accountbalance);
            System.out.println("    Your Account balance : $"+accountbalance);
        }
    }
    public void deposit(double deposit){
        depositamount = deposit;

        if(depositamount <= 20000000) {
            accountbalance += depositamount;
            System.out.println("      Thanks for deposting $" + depositamount + " in your account");
            System.out.println("      Now your account balance is $" + accountbalance);
        }
        else{
            System.out.println("     The maximum deposit amount must within $20000000.");
            System.out.println("     Please , select a amount within $20000000.");
        }
    }
    public void checkbalance(){
        System.out.println("    Your account's current balance is $"+accountbalance);
    }
}
public class Main extends ATMCLASS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ATMCLASS atm = new ATMCLASS();
        userbankaccount user = new userbankaccount();
        boolean condition = true;
        System.out.println();
        System.out.println();
        System.out.println("*** WELCOME TO ONLINE BANK ACCOUNT *** ");
        while(condition == true) {
            System.out.println();
            System.out.println(" Press 1 : To deposit amount ,");
            System.out.println(" Press 2 : To withdraw amount ,");
            System.out.println(" Press 3 : To check account balance,");
            System.out.println("Press 0 : Exit ");
            System.out.println();
            System.out.print("   Your wish here :");
            int i = sc.nextInt();
            System.out.println();
            while (i == 1) {
                System.out.print("   Enter the amount that you want to deposit : $ ");
                double deposit_amount = sc.nextInt();
                user.deposit(deposit_amount);
                System.out.println();
                break;
            }

            while (i == 2) {
                System.out.print("     Enter the amount that you want to withdraw : $ ");
                double withdraw_amount = sc.nextInt();
                user.withdraw(withdraw_amount);
                System.out.println();
                break;
            }

            while (i == 3) {
                System.out.println("     Wait we are fetching your Account balance!");
                System.out.println();
                user.checkbalance();
                break;
            }

            while (i == 0) {
                condition=false;
                System.out.println("    Thank you,Welcome again !");
                System.out.println();
                break;
            }

        }
    }
}