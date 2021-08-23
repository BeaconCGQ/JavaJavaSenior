package exer7;
 /**
  * 开发一个泛型Apple类，要求有一个重量属性weight在测试类中实例化不同的泛型对象，
  * 要求对象a1的这一属性是String类型，对象a2的这一属性是Integer型，
  * a3的这一属性是Double型。分别为a1，a2，a3的重量属性赋值为：”500克”，500,500.0，
  * 在测试类中通过对象调用访问器得到属性值并输出。
  * 另外思考，为什么a2和a3的属性需要是Integer和Double而不是int和double？
  *
  *
  * @author: 86173
  * @date: 2021/4/24 20:37
  */
public class GenericTest {
     public static void main(String[] args) {

         Apple<String>  apple1 = new Apple<>("500克");
         Apple<Integer> apple2 = new Apple<>(500);
         Apple<Double>  apple3 = new Apple<>(500.0);

         System.out.println(apple1.getWeight());

     }
}


class Apple<T>{

    private T weight;

    public Apple(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }
}