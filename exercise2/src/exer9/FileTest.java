package exer9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
  * 6. 利用反射和File完成以下功能
  * 1.利用Class类的forName方法得到File类
  * 2.在控制台打印File类的所有构造器
  * 3.通过newInstance的方法创建File对象，并创建D：\mynew.txt文件
  * @author: 86173
  * @date: 2021/4/26 20:16
  */
public class FileTest {
     public static void main(String[] args) throws Exception {

         Class clazz = Class.forName("java.io.File");//获取File的Class实例

         //获取File的所有构造器并输出
         Constructor[] con = clazz.getDeclaredConstructors();
         for(Constructor c : con){
             System.out.println(c);
         }

         //获取File的一个构造器
         Constructor file1 = clazz.getConstructor(String.class);

         //用上面得到构造器创建File对象
         Object instance = file1.newInstance("d:\\mynew.txt");

         //获取File的createNewFile方法
         Method createNewFile = clazz.getDeclaredMethod("createNewFile");

         //通过createNewFile方法，File对象，完成文件的创建
         createNewFile.invoke(instance);




     }
}
