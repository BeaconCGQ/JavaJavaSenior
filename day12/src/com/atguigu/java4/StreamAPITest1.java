package com.atguigu.java4;

import com.atguigu.java3.Employee;
import com.atguigu.java3.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
  * 测试Stream的中间操作
  *
  * @author: 86173
  * @date: 2021/4/24 14:29
  */
public class StreamAPITest1 {
    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p)     接收 Lambda ， 从流中排除某些元素
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("**************");
        //limit(long maxSize)    截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("*********************");

        //skip(long n)           跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("**********************");

        //distinct()             筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.stream().distinct().forEach(System.out::println);

    }
    //2.映射
    @Test
    public void test2(){

        //map(Function f)  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

          //获取员工姓名长度大于三的员工姓名
        List<Employee> list1 = EmployeeData.getEmployees();
        Stream<String> nameStream = list1.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println("*******************");
        //flatMap(Function f)   接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流


        //mapToDouble(ToDoubleFunction f)  接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
        //mapToInt(ToIntFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
        //mapToLong(ToLongFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。

    }
    //3.排序
    @Test
    public void test3(){

        //sorted()    产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 54, -5, 0, 32, 9);
        list.stream().sorted().forEach(System.out::println);

//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);//异常，Employee没有实现comparable接口

        //sorted(Comparator com)   产生一个新流，其中按比较器顺序排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted( (e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

        Stream<String> name = employees.stream().map(e -> e.getName());
        System.out.println("*****************");
        name.sorted(String :: compareTo).forEach(System.out::println);//只输出名字
    }
}
