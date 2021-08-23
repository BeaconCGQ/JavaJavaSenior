package com.atguigu.java2;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1(){

        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> forList = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student stu = dao2.getIndex(1);
    }
}
