import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author:飞哥
 * @date: 2021/5/23 11:36
 */
public class Main1 {
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                10,
                10,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000)
        );
        for (int i = 0; i < 1000; i++) {
            final int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date=new Date(1000*finalI);
                        myDateFarmat(date);
                }
            });
        }
        executor.shutdown();
    }
       private static synchronized void myDateFarmat(Date date){
        String str=simpleDateFormat.format(date);
        System.out.println(str);
    }
}
