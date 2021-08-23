package exer4;

/**
 * @description:
 * @author: 86173
 * @date: 2021/4/23 18:59
 */
public class EnumTest {
    public static void main(String[] args) {

        Week monday = Week.MONDAY;
        System.out.println(monday);
    }
}

interface info{
    void show();
}
@MyAnnotation(value = "n")
enum Week implements info{

    MONDAY("星期一", "上学1"){
        @Override
        public void show() {
            System.out.println("这是星期一");
        }
    },
    TUESDAY("星期二","上学2"){
        @Override
        public void show() {
            System.out.println("这是星期二");
        }
    },
    SUNDAY("星期日","玩耍1"){
        @Override
        public void show() {
            System.out.println("这是星期日");
        }
    };


   String name;
   String plan;


    Week(String name, String plan) {
        this.name = name;
        this.plan = plan;
    }


}
