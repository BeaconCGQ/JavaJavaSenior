package exer3;
 /**
  * @description:
  * @author: 86173
  * @date: 2021/4/16 20:20
  */
public class BankTest {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.addCustomer("c","gq");
        Customer cust1 = bank.getCustomer(0);
        cust1.setAccount(new Account(2000));
        cust1.getAccount().deposit(1000);
        cust1.getAccount().withdraw(1500);
        Account account = cust1.getAccount();
        System.out.println(account);


    }


}

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }


    public double deposit(double in) {

        if (in >= 0) {
            balance += in;
            return balance;
        } else {
            throw new RuntimeException("输入数据不合理");
        }

    }

    public double withdraw(double out) {
        if (balance >= out && out >= 0) {
            balance -= out;
            return balance;
        } else {
            throw new RuntimeException("输入数据不合理");
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}

class Customer{

    private String firsName;
    private String lastName;
    private Account account;

    public Customer(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}

class Bank{

    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {

        customers = new Customer[10];

    }

    public void addCustomer(String f,String l){

        Customer cust = new Customer(f,l);
        customers[numberOfCustomer++]  = cust;

    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
    public Customer getCustomer(int index){

        if(index >= 0 && index < numberOfCustomer){
            return customers[index];
        }
        throw new RuntimeException("输入索引有误");
    }
}

