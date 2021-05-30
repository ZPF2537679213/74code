import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author:飞哥
 * @date: 2021/5/30 10:03
 */
//循环栅栏CyclicBarrier
public class Main3 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            }
        });
        for (int i = 1; i < 11; i++) {
            final int finalI=i;
           new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName()+"开始起跑");
                   try {
                       Thread.sleep(1000*finalI);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   try {
                       cyclicBarrier.await();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (BrokenBarrierException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+"到达终点");
               }
           }).start();
        }
    }
}
