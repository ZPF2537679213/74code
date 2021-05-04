import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:飞哥
 * @date: 2021/4/30 12:37
 */
public class Main {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock(true);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
              try{
                  System.out.println('a');
              }finally {
                  lock.unlock();
              }

            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println('b');
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println('c');
                }finally {
                    lock.unlock();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
