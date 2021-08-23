package exer2;

public class Demo1 {
    int i;

    void change(int i) {
        i++;
        System.out.println(i);
    }

    void change1(Demo1 t) {
        t.i++;
        System.out.println(t.i);
    }

    public static void main(String[] args) {
        Demo1 ta = new Demo1();
        System.out.println(ta.i); //
        ta.change(ta.i);//
        System.out.println(ta.i); //
        ta.change1(ta);  //
        System.out.println(ta.i);//
    }
}
