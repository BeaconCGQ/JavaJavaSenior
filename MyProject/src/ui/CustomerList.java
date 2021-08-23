package ui;

import bean.Customer;

/**
  * Customer[] customers：用来保存客户对象的数组
  * int total = 0                 ：记录已保存客户对象的数量
  * 该类至少提供以下构造器和方法：
  * public CustomerList(int totalCustomer)
  * public boolean addCustomer(Customer customer)
  * public boolean replaceCustomer(int index, Customer cust)
  * public boolean deleteCustomer(int index)
  * public Customer[] getAllCustomers()
  * public Customer getCustomer(int index)
  * public int getTotal()
  * @author: 86173
  * @date: 2021/4/28 20:11
  */
public class CustomerList {

    Customer[] customers ;
    private int total = 0;

    public CustomerList(int totalCustomer){

        customers = new Customer[totalCustomer];

    }

    public boolean addCustomer(Customer customer){

        if(total < customers.length - 1) {
            customers[total++] = customer;
            return true;
        }
        return false;
    }
    public boolean replaceCustomer(int index, Customer cust){

        if(index > 0 && index <= total ){
            customers[index -1] = cust;
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(int index){

        if(index > 0 && index <= total ){
            for (int i = index - 1; i < total -1;i++){

                customers[i] = customers[i+1];

            }
            customers[total- 1] = null;
            total--;
            return true;
        }
        return false;
    }

    public Customer[] getAllCustomers(){

        Customer[] cust = new Customer[total];

        for (int i = 0; i < total ; i++) {

            cust[i] = customers[i];
        }
        return cust;
    }

    public Customer getCustomer(int index) {
        if (index <= 0  ||  index > total) {
            return null;
        }
        return customers[index - 1];
    }

    public int getTotal() {
        return total;
    }


}


