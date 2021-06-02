import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:飞哥
 * @date: 2021/6/2 10:25
 */
class Student{
    private int id;
    private String name;
    public Student(){}
    private Student(int id,String name){
        this.id=id;
        this.name=name;
    }
    private void show(){
        System.out.println("学号"+this.id+"姓名"+this.name);
    }
}
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //创建class对象
        Student stu=new Student();
        Class<?>sc=stu.getClass();//第一种创建class对象的方法
        Class<?>sc2=Student.class;//第二种创建方式
        Class<?>sec3=Class.forName("Student");//第三种创建方式
        //获取构造方法
        System.out.println("----------------------构造方法的获取方式--------------------------");
        Constructor<?>constructor=sc.getConstructor();//获取公有的一个构造方法
        Constructor<?>[]constructors=sc.getConstructors();//获取所有共有的构造方法，不包含私有的
        Constructor<?>[]constructorss2=sc.getDeclaredConstructors();//获取所有的构造方法
        System.out.println(constructor.toString());
        System.out.println("---------------公有的所有构造方法------------------");
        for(Constructor<?>x:constructors){
            System.out.println(x.toString());
        }
        System.out.println("----------------包括私有的所有的构造方法-----------------");
        for (Constructor<?>x:constructorss2) {
            System.out.println(x.toString());
        }
        System.out.println("----------------------利用获取到的构造方法创建实例化对象---------------------------");
        Student ss=(Student)constructor.newInstance();//利用公共的构造方法创建对象
        constructorss2[1].setAccessible(true);
        Student ss2=(Student)constructorss2[1].newInstance(1,"java");//利用私有的构造方法创建对象
        System.out.println("--------------获取对应类的字段----------------");
        Field[]field=sc.getDeclaredFields();//获取所有的字段
        Field[]fields=sc.getFields();//获取共有的所有字段
        Field ff=sc.getDeclaredField("id");//根据字段名获取到对应的Field对象
        ff.setAccessible(true);//设置访问权限，允许访问私有属性
        System.out.println("field[]的字段");
        for (Field x:field) {
            System.out.println(x);
        }
        field[1].setAccessible(true);
        System.out.println("ff的字段");
        System.out.println("修改前id:"+ff.get(ss)+" "+"修改前name:"+field[1].get(ss));
        ff.set(ss,1);//修改
        field[1].set(ss,"java");
        System.out.println("修改后id:"+ff.get(ss)+" "+"修改后name:"+field[1].get(ss));
        System.out.println("----------------------获取方法------------------------");
        Method[]methods=sc.getMethods();//获取所有共有方法
        Method[]methods1=sc.getDeclaredMethods();//获取所有的方法，包括私有方法
        Method method= sc.getDeclaredMethod("show");//获取一个无参。名为show的方法
        method.setAccessible(true);//设置权限
        method.invoke(ss);//调用对应方法，参数为调用方法的对象名，后面是对应方法的参数，我这里的show方法没有参数
    }
}
