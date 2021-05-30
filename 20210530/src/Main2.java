import java.util.concurrent.CountDownLatch;

/**
 * @author:飞哥
 * @date: 2021/5/30 9:44
 */
//计数器CountDownLatch
public class Main2 {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            final  int finali=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("选手"+Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(1000*finali);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("选手"+Thread.currentThread().getName()+"到达终点");
                    latch.countDown();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都到达了");
    }
}
