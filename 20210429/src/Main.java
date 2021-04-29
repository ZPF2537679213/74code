/**
 * @author:飞哥
 * @date: 2021/4/29 19:09
 */
public class Main {
    private static int number=0;
    public static void main(String[] args) {
        //创建一个锁对象，任意一个Java对象都可以是一把锁
        Object lock=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100000 ; i++) {
                    synchronized (lock){
                        number++;
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100000 ; i++) {
                    synchronized (lock){
                        number--;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println(number);
    }
}
