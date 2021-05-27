
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author:飞哥
 * @date: 2021/5/27 20:00
 */
public class Main3 {
    //设置应用程序参数

    private static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(1000,1);
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result= atomicStampedReference.compareAndSet(1000,0,1,2);
                System.out.println("第一次转账-100 "+result);
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result= atomicStampedReference.compareAndSet(1000,0,1,2);
                System.out.println("第二次转账-100 "+result);
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result= atomicStampedReference.compareAndSet(0,1000,2,3);
                System.out.println("入账+100 "+result);
            }
        });
        t1.join();
        t3.start();
        t3.join();
        t2.start();
    }
}
