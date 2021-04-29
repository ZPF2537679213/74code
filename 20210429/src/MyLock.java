import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:飞哥
 * @date: 2021/4/29 20:41
 */
public class MyLock {
    private static int number=0;
    public static void main(String[] args) {
        //创建一个手动锁
        Lock lock=new ReentrantLock();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100000 ; i++) {
                    lock.lock();//一定把lock放在try外面
                    try{
                        number++;
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100000 ; i++) {
                        number--;
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println(number);
    }
}
