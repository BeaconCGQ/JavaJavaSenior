package exer5;

import org.junit.Test;

import java.util.*;

/**
  *
  * @author: 86173
  * @date: 2021/4/23 20:07
  */
public class CollectionTest {
    /*
    定义一个Collection接口类型的变量，引用一个Set集合的实现类，实现添加单个元素，添加另一个集合，
    删除元素，判断集合中是否包含一个元素，判断是否为空，清除集合，返回集合里元素的个数等常用操作。
     */
    @Test
    public void test1(){

        Collection Set = new HashSet();
        Set.add("cgq");
        System.out.println(Set);
        Collection Set1 = new HashSet();
        Set1.add("bvc");
        Set.addAll(Set1);
        System.out.println(Set);
        Set.remove("bvc");
        System.out.println(Set);

        System.out.println(Set.contains("cgq"));
        System.out.println(Set.isEmpty());
        System.out.println(Set.size());
        Set.clear();

    }
    /*
    创建Set接口的实现类，添加10个以上的元素，通过Iterator遍历此集合元素。
     */
    @Test
    public void test2(){

        Set set = new HashSet();
        for(int i = 0; i < 10;i++){
            set.add(i);
        }
       Iterator iterator =  set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        for(Object o : set){
            System.out.print(o + " ");
        }
    }
    /*
    创建Set接口的实现类，添加10个以上的元素，要求能够排序。
     */
    @Test
    public void test3(){

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.compareTo(o2);
            }
        };


        Set<String> set = new TreeSet<>(com);
        set.add("cgq");
        set.add("hlm");
        set.add("agj");
        set.add("sde");
        set.add("sdr");

        System.out.println(set);

    }
}
