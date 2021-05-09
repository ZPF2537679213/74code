import java.util.Collection;

/**
 * @author:飞哥
 * @date: 2021/5/9 8:27
 */
public class Main {
    public static void main(String[] args) {
        //实现死锁
        Object o1=new Object();
        Object o2=new Object();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("线程1的得到A");
                    try {
                        //休眠一秒，让线程2先得到B
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1等待获取B");
                    synchronized (o2){
                        System.out.println("线程1得到B");
                    }
                }
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("线程2获取B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2等待获取A");
                    synchronized (o1){
                        System.out.println("线程2获取到A");
                    }
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
