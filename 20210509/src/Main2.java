/**
 * @author:飞哥
 * @date: 2021/5/9 11:09
 */
public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入线程方法。");
                synchronized (o1){
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        synchronized (o1){
            o1.notify();
        }
    }
}
