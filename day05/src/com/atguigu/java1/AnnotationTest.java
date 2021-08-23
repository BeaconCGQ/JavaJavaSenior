package com.atguigu.java1;

import com.atguigu.MyAnnotation;

/**
 * 一、注解使用：jdk5.0新增
 * <p>
 * ① Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * <p>
 * ②在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等
 * <p>
 * 二、 使用实例：
 *    ① ：生成文档相关的注解
 *    ② ：在编译时进行格式检查(JDK内置的三个基本注解)
 *  @Override: 限定重写父类方法, 该注解只能用于方法
 *  @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *  @SuppressWarnings: 抑制编译器警告
 * <p>
 * ③ ：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * 三、 如何自定义注解：参照@SuppressWarnings定义
 *     ①注解声明为 : @interface
 *     ②内部定义成员，通常使用value
 *     ③可以指定成员默认值，使用default定义
 *     ④如果自定义注解没有成员，表明是标识作用
 * <p>
 * 如果注解有成员，使用注解时，需要指明成员值
 * 在反射中使用采用意义
 * <p>
 * 四、jdk提供的4种元注解：
 * 解释：对现有注解进行修饰
 * <p>
 * Retention ：指定该 Annotation 的生命周期 SOURCE/CLASS(默认行为)/RUNTIME
 *             只有声明为RUNTIME生命周期的注解，才能通过反射获取
 * Target ：用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
 * Documented ：用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。
 * Inherited ：被它修饰的 Annotation 将具有继承性
 *     通常自定义注解指明两个元注解：Retention、Target
 * <p>
 * 五、通国反射获取注解信息
 * <p>
 * 六、jdk8新特性：
 * 可重复的注解:①在MyAnnotation上声明@Repeatable，成员值为MyAnnotation.class
 * ②MyAnnotation的Target和Retention和MyAnnotations相同
 * 可用于类型的注解
 *
 * @author: 86173
 * @date: 2021/4/13 20:14
 */

public class AnnotationTest {
}

@MyAnnotation(value = "hello")//注解

class Person {

    String name;
    int age;

    @MyAnnotation
    public Person() {
    }

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void walk() {
        System.out.println("走路");
    }
}