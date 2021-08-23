package exer2;

public class Demo {
    public static void main(String[] args) {
        show(0);
        show(1);
    }

    public static void show(int i) {
        switch (i) {
            default:
                i += 2;
            case 1:
                i += 1;
            case 4:
                i += 8;
            case 2:
                i += 4;
        }
        System.out.println("i=" + i);
    }
}
/*
   i 若都不匹配，则从default开始执行，并且若无break、continue语句，继续执行后面的语句
     若成功匹配，则执行哇匹配的case语句后，若无break、continue语句，会继续执行后面语句

 */
