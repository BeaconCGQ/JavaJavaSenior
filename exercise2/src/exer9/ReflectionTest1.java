package exer9;

import java.lang.reflect.Constructor;

/**
  * 2. 利用反射和重载完成以下功能
  * 1)创建Student类，类中有属性name和age并封装属性
  * 2)重载Student的构造函数，一个是无参构造并，另一个是带两个参数的有参构造，要求在构造函数打印提示信息
  * 3)创建带main函数的NewInstanceTest类，利用Class类得到Student对象
  * 4)通过上述获取的Class对象分别调用Student有参函数和无参函数
  * @author: 86173
  * @date: 2021/4/26 19:25
  */
public class ReflectionTest1 {
    public static void main(String[] args) throws Exception {

        Class<Student> s1 = Student.class;

        Student s3 = s1.newInstance();

        Constructor<Student> d1 = s1.getDeclaredConstructor(String.class, int.class);
        d1.setAccessible(true);

        Student s2 = d1.newInstance("Tom", 12);



    }

}
