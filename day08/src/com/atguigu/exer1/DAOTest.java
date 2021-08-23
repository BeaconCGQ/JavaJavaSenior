package com.atguigu.exer1;

import java.util.List;

/**
  * 定义一个测试类：
  * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
  * 使用 Junit 单元测试类进行测试。
  *
  * @author: 86173
  * @date: 2021/4/19 13:00
  */
public class DAOTest {
     public static void main(String[] args) {

         DAO<User> dao = new DAO<>();
         dao.save("1001",new User("张三",101,34));
         dao.save("1002",new User("李四",102,25));
         dao.save("1003",new User("王五",103,45));

         dao.update("1003",new User("钱六",104,56));

         dao.delete("1002");

         List<User> list = dao.list();
//         System.out.println(list);
         list.forEach(System.out::println);
     }
}
