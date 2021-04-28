/**
 * @author:飞哥
 * @date: 2021/4/28 15:40
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名"+Thread.currentThread().getName());
            }
        };
        Thread thread=new Thread(runnable);
        for(int i=0;i<5;++i){
            thread.run();
        }

    }
}
