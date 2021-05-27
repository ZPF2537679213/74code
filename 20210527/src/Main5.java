/**
 * @author:飞哥
 * @date: 2021/5/27 21:06
 */
public class Main5 {
    public static void main(String[] args) {
        Object o=new Object();
        synchronized (o){
            System.out.println("第一次进入锁");
            synchronized (o){
                System.out.println("第二次进入锁");
            }
        }
    }
}
