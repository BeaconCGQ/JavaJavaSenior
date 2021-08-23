package exer3;

public class CheckAccountTest {
    public static void main(String[] args) {

//        Account1 acc = new Account1(1122, 20000, 0.045);
//        acc.withdraw(3000);
//        double b1 = acc.getBalance();
//        System.out.println(b1);
//        acc.withdraw(2500);
//        acc.deposit(3000);
//        double b2 = acc.getBalance();
//        double m1 = acc.getMonthlyInterest();
//        System.out.println(b2);
//        System.out.println(m1);

        CheckAccount account = new CheckAccount(1122,20000,0.045,5000);
        account.withdraw(5000);
        System.out.println("余额：" +account.balance + " ,可透支余额： " + account.getOverdraf());
        account.withdraw(18000);
        System.out.println("余额：" +account.balance + " ,可透支余额： " + account.getOverdraf());
        account.withdraw(3000);
        System.out.println("余额：" +account.balance + " ,可透支余额： " + account.getOverdraf());


    }
}


class Account1 {

    private int id;//账号
    protected double balance;//余额
    private double annualInterestRate;//年利率

    public Account1() {
    }

    public Account1(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {

        return annualInterestRate / 12;

    }

    public void withdraw(double amount) {

        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("取款成功");
        } else {
            System.out.println("余额不足");
        }

    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("存钱成功");
        } else {
            System.out.println("存钱失败");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}

class CheckAccount extends Account1{

    private double overdraf;

    public CheckAccount() {
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraf) {
        super(id, balance, annualInterestRate);
        this.overdraf = overdraf;
    }

    //如果（取款金额<账户余额），
    //可直接取款
    //如果（取款金额>账户余额），
    //计算需要透支的额度
    //判断可透支额 overdraft 是否足够支付本次透支需要，如果可以
    //将账户余额修改为 0，冲减可透支金额
    //如果不可以
    //提示用户超过可透支额的限额
    @Override
    public void withdraw(double amount) {
        if(amount < balance){

            balance -= amount;
            System.out.println("取款成功");
        }
        if(amount > balance){
            if(overdraf >= (amount - balance)){
                overdraf -= (amount - balance);
                balance = 0;
                System.out.println("取款成功");
            }else{
                System.out.println("可透支余额不足");
            }

        }
    }

    public double getOverdraf() {
        return overdraf;
    }

    public void setOverdraf(double overdraf) {
        this.overdraf = overdraf;
    }
}