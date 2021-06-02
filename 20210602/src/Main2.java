import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Enum;
/**
 * @author:飞哥
 * @date: 2021/6/2 13:36
 */
enum Color{
    RED(1,"红色"),GREEN(2,"绿色"),BLACK(3,"黑色");//枚举对象的定义必须在最前
    private int num;
    private String color;
    Color(int num,String color){
        this.color=color;
        this.num=num;
    }
    @Override
    public String toString() {
        return "Color{" +
                "num=" + num +
                ", color='" + color + '\'' +
                '}';
    }
}
public class Main2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取对应的Class类对象
        Class<?>enum1=Color.class;
        //获取构造方法，由于枚举的构造方法默认是私有的，所以直接采用带有Declared的
        Constructor<?>constructor=enum1.getDeclaredConstructor(String.class,int.class,int.class,String.class);
        //创建实例化对象
        constructor.setAccessible(true);
        Color color=(Color)constructor.newInstance("java",1,1,"黑色");
    }
}

