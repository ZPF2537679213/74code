import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/4/25 18:47
 */
public class Main {
    /*public static final Long count=5_0000_0000L;
    public static void main(String[] args) throws InterruptedException {
     concirrency();
     serial();
    }

    private static void concirrency() throws InterruptedException {
        Long stime=System.currentTimeMillis();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for(int i=0;i<count;++i){
                    a++;
                }
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for(int i=0;i<count;++i){
                    a++;
                }
            }
        });
        t2.start();
        int a=0;
        for(int i=0;i<count;++i){
            a++;
        }
        //等待线程t1和t2执行完之后，才统计时间
        t1.join();
        t2.join();
        Long etime=System.currentTimeMillis();
        System.out.println("多线程执行30亿次时间"+(etime-stime));
    }

    public static void serial() {
        Long stime=System.currentTimeMillis();
        //System.nanoTime();纳秒
        int a=0;
        for(int i=0;i<3*count;++i){
            a++;
        }
        Long etime=System.currentTimeMillis();
        System.out.println("单线程执行30亿次时间"+(etime-stime));
    }*/
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        //1
        Thread.sleep(1000);
        System.out.println(new Date());
        //2
        TimeUnit.SECONDS.sleep(1);
        //3
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}
