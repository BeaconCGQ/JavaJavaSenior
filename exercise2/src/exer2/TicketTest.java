package exer2;

public class TicketTest {
    public static void main(String[] args) {

        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Ticket implements Runnable{

    private static int ticket = 100;


    public void run(){

        while(true)
        synchronized (this){
            notify();

            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                break;
            }

        }


    }



}