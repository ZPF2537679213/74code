import java.util.concurrent.atomic.AtomicReference;

/**
 * @author:飞哥
 * @date: 2021/5/27 19:50
 */
public class Main2 {
    private static AtomicReference<Integer>atomicReference=new AtomicReference<>(100);
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
              boolean result= atomicReference.compareAndSet(100,0);
                System.out.println("第一次转账-100 "+result);
            }
        });
            t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result= atomicReference.compareAndSet(100,0);
                System.out.println("第二次转账-100 "+result);
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result= atomicReference.compareAndSet(0,100);
                System.out.println("入账+100 "+result);
            }
        });
        t1.join();
        t3.start();
        t3.join();
        t2.start();
    }
}
