import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:飞哥
 * @date: 2021/5/27 18:51
 */
public class Main {
    //private static int count=0;
    private static final int maxsize=10_0000;
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    count++;
                }
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    count--;
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);*/
        AtomicInteger count=new AtomicInteger(0);
        //count.getAndIncrement();//得到值进行++；i++
        //count.incrementAndGet();//++i
        //System.out.println(count.incrementAndGet());
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    count.getAndIncrement();
                }
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    count.getAndDecrement();
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.get());
    }
}
