package thread;

/**
 * @author:飞哥
 * @date: 2021/4/22 21:14
 * 多线程创建
 */
public class Main {
    public static void main(String[] args) {
        //线程创建
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //业务代码
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
    }
}
