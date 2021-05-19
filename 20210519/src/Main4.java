import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/5/19 20:12
 */
public class Main4 {
    public static void main(String[] args) {
        //创建可执行定时任务的线程池
        //法一
       /* ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
        //执行任务
        System.out.println(new Date());
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },1,3, TimeUnit.SECONDS);
        System.out.println(new Date());*/
        //法二：
       /* ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
        //执行任务
        System.out.println(new Date());
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },3, TimeUnit.SECONDS);
        System.out.println(new Date());*/
        //法三
        ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
        //执行任务
        //System.out.println(new Date());
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        },1,3, TimeUnit.SECONDS);
        System.out.println(new Date());
    }
}
