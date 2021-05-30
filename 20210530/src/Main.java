import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/5/30 9:03
 */
//信号量
public class Main {
    public static void main(String[] args) {
        //创建信号量
        Semaphore semaphore=new Semaphore(2);
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                10,
                10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100)
        );
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"到达停车场");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //试图进入停车场
                    try {
                        //尝试获取锁
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //当代码执行到这，说明已经获取到锁
                    System.out.println(Thread.currentThread().getName()+"进入停车场");
                    int num=1+new Random().nextInt(5);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println(Thread.currentThread().getName()+"离开停车场");
                        semaphore.release();
                    }
                }
            });
        }
    }
}
