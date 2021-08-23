package com.atguigu.java;

public class Test1 {
    public static void main(String[] args) {

        S[] values = S.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].name);

        }
    }

}


enum S{


    SPRING("春天","温暖"),
    SUMMER("夏天","炎热");

     String name;
     String info;

    private S(String name,String info){
        this.name = name;
        this.info = info;
    }

    S() {
    }




}
