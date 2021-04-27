package callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:54
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int num=new Random().nextInt(10);
        System.out.println(Thread.currentThread().getName());
        return num;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个Callable
        MyCallable myCallable=new MyCallable();
        //创建一个容器
        FutureTask<Integer>futureTask=new FutureTask<>(myCallable);
        Thread thread=new Thread(futureTask);
        thread.start();
        int result=futureTask.get();
        System.out.println(Thread.currentThread().getName()+" "+result);
    }
}
