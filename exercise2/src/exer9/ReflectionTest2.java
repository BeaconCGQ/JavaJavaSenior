package exer9;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
  * 3. 利用反射的知识完成下面的操作
  * 1)创建Mytxt类，创建myCreate()方法完成创建文件D:\myhello.txt文件的功能。创建带main方法的NewInstanceTest类，
  * 通过Class类获取Mytxt对象，调用myCreat()
  * @author: 86173
  * @date: 2021/4/26 19:43
  */
public class ReflectionTest2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> clazz = Class.forName("exer9.Mytxt");
        Mytxt m1 = (Mytxt) clazz.newInstance();
        Method m2 = clazz.getDeclaredMethod("myCreate");
        m2.setAccessible(true);
        m2.invoke(m1);

    }
}


class Mytxt{

    private void myCreate() throws IOException {

        File file = new File("D:\\myhello.txt");
        if(file.exists()){
            file.delete();
            System.out.println("文件删除成功");
        }else{
            file.createNewFile();
            System.out.println("文件创建成功");
        }
    }
}
