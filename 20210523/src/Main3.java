import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author:飞哥
 * @date: 2021/5/23 15:24
 */
public class Main3 {
    static ThreadLocal<SimpleDateFormat>threadLocal=ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            System.out.println("--------------------hhhhhhh---------------------");
            return new SimpleDateFormat("mm:ss");
        }
    });
    public static String myformat(Date date){
        return threadLocal.get().format(date);
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                10,
                15,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000)
        );
        for (int i = 0; i < 1000; i++) {
            final int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                   String str=myformat(new Date(1000*finalI));
                    System.out.println(str);
                }
            });
        }
    }
}

