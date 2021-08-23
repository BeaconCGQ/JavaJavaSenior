package com.atguigu.java1;

/**
 * @author: 86173
 * @date: 2021/4/13 12:43
 */
public class Goods implements Comparable {
    private String name;
    private int age;

    public Goods() {

    }

    public Goods(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //商品比较大小
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.age > goods.age) {
                return 1;
            } else if (this.age < goods.age) {
                return -1;
            } else {
//                return 0;
                return this.name.compareTo(goods.name);
            }
//             return Double.compare(this.age,goods.age);  //方式二
        }throw new RuntimeException("传入数据类型不一致");
    }
}
