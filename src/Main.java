import java.util.*;

class Transaction {
    protected String type ;
    protected double transaction_amount;

    public Transaction(String type ,double transaction_amount){
        this.type = type;
        this.transaction_amount = transaction_amount;
    }
}
class ATMCLASS {
    public ArrayList<Transaction> transactionsHistory;
    protected double accountbalance=0 ;
    protected double balance  ;
    protected double withdrawamount;
    protected double depositamount;
    protected double remainingamount;
    public ATMCLASS(){
        this.balance = 0.0 ;
        this.transactionsHistory = new ArrayList<>();
    }

    public void withdraw(double amount1){
        withdrawamount = amount1;
        if(withdrawamount  <= accountbalance){
            remainingamount = accountbalance - withdrawamount;
            System.out.println("    Congratulations, your transaction of $"+withdrawamount+" is successful.");
            accountbalance = accountbalance - withdrawamount;
            System.out.println("    Your remaining Account Balance is : $"+ accountbalance);
            transactionsHistory.add(new Transaction("Withdraw", amount1));
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
            transactionsHistory.add(new Transaction("Deposit", deposit));
        }
        else{
            System.out.println("     The maximum deposit amount must within $20000000.");
            System.out.println("     Please , select a amount within $20000000.");
        }
    }
    public void checkbalance(){
        System.out.println("    Your account's current balance is $"+accountbalance);
    }
    public ArrayList<Transaction> showTransactionHistory() {
        return transactionsHistory;
    }
}
public class Main extends ATMCLASS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ATMCLASS user = new ATMCLASS();
        boolean condition = true;
        System.out.println();
        System.out.println();
        System.out.println("*** WELCOME TO ONLINE BANK ACCOUNT *** ");
        while(condition == true) {
            System.out.println();
            System.out.println("  1 => To Deposit amount ,");
            System.out.println("  2 => To Withdraw amount ,");
            System.out.println("  3 => To Check Account Balance,");
            System.out.println("  4 => To see Transaction History, ");
            System.out.println("  0 => Exit ");
            System.out.println();
            System.out.print("   Your wish here :");
            int i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("   Enter the amount that you want to deposit : $ ");
                double deposit_amount = sc.nextDouble();
                user.deposit(deposit_amount);
                System.out.println();
            }

            if (i == 2) {
                System.out.print("     Enter the amount that you want to withdraw : $ ");
                double withdraw_amount = sc.nextDouble();
                user.withdraw(withdraw_amount);
                System.out.println();
            }

            if (i == 3) {
                System.out.println("     Wait we are fetching your Account balance!");
                System.out.println();
                user.checkbalance();
            }
             if (i==4){
                ArrayList<Transaction> transactionsamount = user.showTransactionHistory();
                System.out.println("Transaction History:");
                for (Transaction transaction : transactionsamount) {
                    System.out.println(transaction.type + ": $" + transaction.transaction_amount);
                }
            }

            if (i == 0) {
                condition=false;
                System.out.println("    Thank you,Welcome again !");
                System.out.println();
            }

        }
    }
}