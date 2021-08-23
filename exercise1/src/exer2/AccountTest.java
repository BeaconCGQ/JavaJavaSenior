package exer2;

/**
  * 定义银行账户类Account，有属性：卡号cid，余额balance，所属用户Customer
  * 银行账户类Account有方法：
  * （1）getInfo()，返回String类型，返回卡的详细信息
  * （2）取钱方法withdraw()，参数自行设计，如果取钱成功返回true，失败返回false
  * （3）存钱方法save()，参数自行设计，如果存钱成功返回true，失败返回false
  *
  * 其中Customer类有姓名、身份证号、联系电话、家庭地址等属性
  *     Customer类有方法say()，返回String类型，返回他的个人信息。
  *
  * 在测试类Bank中创建银行账户类对象和用户类对象，并设置信息，与显示信息
  * @author: 86173
  * @date: 2021/4/15 20:45
  */
public class AccountTest {
    public static void main(String[] args) {

        Customer cust = new Customer("Tom","340321","1372134","上海",new Account(101,1000));
        cust.getAccount().withdraw(500);

        cust.getAccount().save(600);
        String show = cust.show();


    }
}

class Account{
    private int cid;
    private double balance;

    public Account() {
    }

    public Account(int cid, double balance) {
        this.cid = cid;
        this.balance = balance;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getInfo(){

        return "卡号：" + cid + " -- " + "余额： " + balance;
    }

    public boolean withdraw(double out){

        if(out <= balance && out > 0){
            balance -= out;
            return true;
        }else{
            return false;
        }
    }

    public boolean save(double in){
        if(in > 0){
            balance += in;
            return true;
        }else{
            return false;
        }
    }
}

class Customer{
    private String name;
    private String identifier;
    private String phone;
    private String address;
    private Account account;

    public Customer() {
    }

    public Customer(String name, String identifier, String phone, String address, Account account) {
        this.name = name;
        this.identifier = identifier;
        this.phone = phone;
        this.address = address;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String show(){

        return name + " -- " + identifier + " -- " + phone + " -- " + address + "--" +account.getCid() +
                " -- " + account.getBalance();
    }

}