package View;

import Util.CMUtility;
import bean.Customer;
import ui.CustomerList;

public class CustomerView {
    public static void main(String[] args) {

        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }


    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("王涛", '男', 23, "13867583984", "wt@gmail.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("-----------------客户信息管理软件-----------------\n");

            System.out.println("                   1 添 加 客 户                 ");
            System.out.println("                   2 修 改 客 户                 ");
            System.out.println("                   3 删 除 客 户                 ");
            System.out.println("                   4 客 户 列 表                 ");
            System.out.println("                   5 退       出                 \n");
            System.out.println("                   请选择(1-5)：                 \n");
            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N)：");
                    if ('Y' == (CMUtility.readConfirmSelection())) {
                        isFlag = false;
                    }
            }

        }
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String phone = CMUtility.readString(20);
        System.out.println("邮箱：");
        String email = CMUtility.readString(20);
        Customer cust = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(cust);

        if (isSuccess) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------客户目录已满，添加失败---------------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        System.out.println("请选择待修改客户编号(-1退出)：");
        Customer cust  = null;
        int read ;
        while (true) {
             read = CMUtility.readInt();
            if (read == -1) {
                return;
            }

            cust = customerList.getCustomer(read);
            if (cust == null) {

                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }

        System.out.println("姓名(" +cust.getName()+ "):");
        String name = CMUtility.readString(10);
        System.out.println("性别(" +cust.getGender() + "):");
        char gender = CMUtility.readChar();
        System.out.println("年龄(" + cust.getAge() + "):");
        int age = CMUtility.readInt();
        System.out.println("电话(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(20);
        System.out.println("邮箱(" + cust.getEmail() + "):");
        String email = CMUtility.readString(20);
        Customer cust1 = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.replaceCustomer(read, cust1);
        if(isSuccess){
            System.out.println("---------------------修改完成---------------------");
        }else{
            System.out.println("---------------------修改失败---------------------");
        }

    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        System.out.println("请选择待删除客户编号(-1退出)：");
        int read;
        while(true) {
             read = CMUtility.readInt();
            if (read == -1) {
                return;
            }
            Customer cust = customerList.getCustomer(read);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
            System.out.println("确认是否删除(Y/N)：");
            if('Y' == CMUtility.readConfirmSelection()) {
                boolean isSuccess = customerList.deleteCustomer(read);
                if(isSuccess){
                    System.out.println("---------------------删除完成---------------------");
                }else{
                    System.out.println("---------------------删除失败---------------------");
                }
            }else {
                return;
            }
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------\n");
        Customer[] custs = customerList.getAllCustomers();
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录！");
            return;
        }

        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
        for (int i = 0; i < customerList.getTotal(); i++) {
            Customer cust = custs[i];
            System.out.println((i+1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" +
                    cust.getPhone() + "\t" + cust.getEmail());

        }
        System.out.println("\n-------------------------客户列表完成-------------------------\n");
    }

}
