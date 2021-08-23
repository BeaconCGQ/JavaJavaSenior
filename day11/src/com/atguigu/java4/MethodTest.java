package com.atguigu.java4;

import com.atguigu.java3.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description: 获取运行时类的方法结构
 * @author: 86173
 * @date: 2021/4/23 14:22
 */
public class MethodTest {
    @Test
    public void test1() {

        Class clazz = Person.class;

        //getMethods(): 获取当前运行时类及所有父类(包括Object)所有声明为public的方法
        Method[] methods = clazz.getMethods();
        for(Method m: methods){
//            System.out.println(m);
        }

        //getDeclaredMethods(): 获取当前运行时类中自己声明的所有权限的方法（不包括父类）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }

    }

    /**
     * @Xxx
     * 权限修饰符 返回值类型 方法名(参数类型 形参名...)throws XxxException{}
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {

            //1.获取方法声明的注解：
            Annotation[] annos = m.getAnnotations();
            for(Annotation a : annos){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName() +"\t");

            //5.形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){
                    if(i == parameterTypes.length - 1){

                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }

            System.out.print(")");

            //6.异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}
