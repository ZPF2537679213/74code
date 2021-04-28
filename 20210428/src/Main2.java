/**
 * @author:飞哥
 * @date: 2021/4/28 15:50
 */
public class Main2 {
    private static int num=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
                num++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread[]threads=new Thread[20];
        for(int i=0;i<20;++i){
            threads[i]=new Thread(runnable);
        }
        for(Thread x:threads){
            x.start();
            x.join();
        }
        System.out.println("OK");
    }
}
