package exer9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
  * @description:
  * @author: 86173
  * @date: 2021/4/26 20:05
  */
public class TestGetAnno {

     public static void main(String[] args) throws Exception {

         Class<Student1> s1 = Student1.class;
         Student1 s2 = s1.newInstance();
         Method toString = s1.getDeclaredMethod("toString");
         toString.setAccessible(true);


         Annotation[] list = toString.getAnnotations();
         for(Annotation an : list){
             System.out.println(an);
         }
     }
}
