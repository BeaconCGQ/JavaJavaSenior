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
public class FiletEST1 {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("java.io.File");
        Constructor<?>[] con = clazz.getDeclaredConstructors();
        for(Constructor c: con){
            System.out.println(c);
        }

        Constructor<?> con1 = clazz.getConstructor(String.class);
        Object obj = con1.newInstance("D：\\mynew.txt");

        Method method = clazz.getDeclaredMethod("createNewFile");

        method.setAccessible(true);

        method.invoke(obj);
    }
}
