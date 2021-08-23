package com.atguigu.java1;

/**
 * 使用同步机制将单例模式中懒汉式改为线程安全的
 *
 * @author: 86173
 * @date: 2021/4/10 18:56
 */


public class BankTest {

}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //效率低
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//      效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }

        }
        return instance;
    }
}