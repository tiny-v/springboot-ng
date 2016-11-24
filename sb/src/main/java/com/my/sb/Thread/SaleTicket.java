package com.my.sb.Thread;

/*问题原因：当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没执行完，另一个线程参与进来执行，导致共享数据的错误。

解决办法：对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不执行。*/

public class SaleTicket {
    public static void main(String[] args){
        Ticket t =new Ticket();
        Thread t1 = new Thread(t,"窗口一");
        Thread t2 = new Thread(t,"窗口二");
        Thread t3 = new Thread(t,"窗口三");
        Thread t4 = new Thread(t,"窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Ticket implements Runnable{
    private int ticket =400;
    public void run(){
        while(true){
            synchronized (Ticket.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(ticket<=0)
                    break;
                System.out.println(Thread.currentThread().getName()+"---卖出"+ticket--);
            }
        }
    }
}
