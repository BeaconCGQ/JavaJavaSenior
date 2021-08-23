package com.atguigu.java1;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
  *    |----Map:双列数据，用于存储key-value的数据
  *         |----HashMap: 作为Map主要实现类，线程不安全，效率高，存储null的key或value
  *             |----LinkedHashMap: 保证遍历Map元素时，按照添加顺序遍历
 *                             原因:在原有HashMap底层结构基础上，添加了一对指针，指向前后元素
 *                             对于频繁遍历操作，LinkedHashMap执行效率高于HashMap
  *         |----TreeMap:保证按照添加的key-value进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                       底层使用红黑树
  *         |----Hashtable:作为Map古老实现类，线程安全，效率低，不能存储null的key或value
  *             |----Properties:常用来处理配置文件。key-value都是String类型
  *
 *   HashMap底层：数组+链表（jdk7之前）
 *               数组+链表+红黑树（jdk8)
  *
 * 面试题：
 * 1.HashMap底层使用原理：
 * 2.HashMap和Hashtable异同：
 * 3.CurrentHashMap 与Hashtable的异同？
 *
 * 二、Map结构理解：
 *  Map中的key：无序、不可重复，使用Set存储所有的key  -------------->要求key所在的类重写equals()和hashCode()方法 （以HashMap为例）
 *  Map中的value：无序、可重复，使用Collection存储所有的value ------>要求所在类要重写equals()
 *  一个键值对：key-value构成一个Entry对象
 *  Map中的entry：无序、不可重复，使用Set存储所有的entry
 *
 *  三、HashMap底层实现原理：
 *    1.jdk7：
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了长度为16的一维数组Entry[] table;
 *      ...已执行多次put...
 *      map.put(key1,value1):
 *      首先计算key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中存放位置。
 *      如果此位置上数据为空，此时key1-value1添加成功 ------->情况1
 *      如果此位置上数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的一个或多个数据的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。------->情况2
 *          如果key1的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同，继续比较，调用key1所在类的equals(key2)方法，比较：
 *                 如果equals()返回false：则key1-value1添加成功 -------->情况3
 *                 如果equals()返回true：使用value1替换相同key的value2.
 *     关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *     若涉及扩容问题：超出临界值时（且存放位置不空），默认扩容为原来容量的2倍，并复制原有数据.
 *
 *    2.jdk8不同点：
 *      1.new HashMap():底层没有创建一个长度为16的数组
 *      2.底层数组是Node[],而非Entry[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4。jdk7底层结构只有：数组+链表。jdk8底层结构：数组+链表+红黑树
 *         当数组某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组长度 > 64 ,此时此索引位置上的所有数据改为红黑树存储
 *
 *   3.DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *     DEFAULT_LOAD_FACTOR：HashMap的默认加载因子 ： 0.75
 *     threshold：扩容的临界值，=容量*填充因子： 16 * 0.75 => 12
 *     TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
 *     MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量 :64 （当桶中Node的
 *          数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行
 *          resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。）
 *
 *  四、LinkedHashMap底层原理实现：（了解）
 *       static class Entry<K,V> extends HashMap.Node<K,V> {
 *            Entry<K,V> before, after;//能够记录添加元素的先后顺序
 *            Entry(int hash, K key, V value, Node<K,V> next) {
 *            super(hash, key, value, next);
 * } }
 *
  * @author: cgq
  * @date: 2021/4/17 18:44
  */
public class MapTest {

    @Test
    public void test2(){


        Map map = new LinkedHashMap();

        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }

    @Test
    public void test1(){

        Map map = new HashMap();

        map.put(null,123);
        map.put(null,null);


    }
}
