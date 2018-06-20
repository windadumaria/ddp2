public class Account {
    private double balance;
    public Account()
    {
        this.balance = 0;
    }
    public Account (double newBalance)
    {
        this.balance = newBalance;
    }
    public void deposit (double money)
    {
        this.balance = (balance+money)-(0.15*money);
    }
    public void withdraw (double money)
    {
        if((balance-money)- (0.15*money) < 0){
            System.out.println("Penarikan tidak bisa dilakukan. Sisa saldo anda " + this.balance);
        }else{
            this.balance = (balance-money)-(0.15*money);
        }
    }
    public void setBalance(double newBalance)
    {
        this.balance = newBalance;
    }
    public double getBalance()
    {
        return this.balance;
    }
}
