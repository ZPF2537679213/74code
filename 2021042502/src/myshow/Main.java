package myshow;

import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/4/25 20:33
 */
public class Main {
    public static void main(String[] args) {
    show();
    }
    public static void show(){
        String str="ABCD";
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(char x:str.toCharArray()){
                    System.out.print(x);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(char x:str.toCharArray()){
                    System.out.print(x);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }
}
