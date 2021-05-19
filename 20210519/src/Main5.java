import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/5/19 20:58
 */
public class Main5 {
    public static void main(String[] args) {
        //创建单个定时任务
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },1,3, TimeUnit.SECONDS);
    }
}
