import com.sun.deploy.net.proxy.WDefaultBrowserProxyConfig;

/**
 * @author:飞哥
 * @date: 2021/4/27 10:23
 */
public class Main {
    class P{
        static final int a=10;
    }
    static class PP{
        int a=10;
    }
     int s;
     static void main1(String[] args) {
        final byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3=b1+b2;
        System.out.println(b3+b6);
        byte b=1;
        b=(byte)(b>>1);
    }
}
class Test2
{
    public static void add(Byte b)
    {
        b = b++;
    }
    public  static void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }

    public static void main(String[] args) {
        test();
    }
}

