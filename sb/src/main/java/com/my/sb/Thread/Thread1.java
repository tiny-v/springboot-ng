package com.my.sb.Thread;

public class Thread1{

	public static void main(String[] args){
		/*MyThread1 thread1 = new MyThread1();
		thread1.start();*/
		Demo2 thread2 = new Demo2();
		thread2.run();
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"   "+i);
		}
	}

}


class MyThread1 extends Thread{
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"   "+i);
		}
		
	}
}

class Demo2 implements Runnable{
    public void run(){
        for(int x=0;x<60;x++){
            System.out.println(Thread.currentThread().getName()+x);
        }
    }
}