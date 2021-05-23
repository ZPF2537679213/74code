import java.util.function.Supplier;

/**
 * @author:飞哥
 * @date: 2021/5/23 15:16
 */
public class Main2 {
    static ThreadLocal<String>threadLocal=ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了初始化方法");
            return "java";
        }
    });
    public static void main(String[] args) {
        String str=threadLocal.get();
        System.out.println(str);
    }
}
