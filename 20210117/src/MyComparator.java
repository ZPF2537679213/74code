import java.util.Arrays;
class Student2{
   public String name;
   public int age;
    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Student2(){

    }
    public Student2(String name,int age){
        this.name=name;
        this.age=age;
    }
}
public class MyComparator {
    public static void main(String[] args) {
        Student2[]stu=new Student2[]{new Student2("zhangsan",38),new Student2("lisi",20),new Student2("wangmazi",30)};
        for(Student2 x:stu) {
            System.out.println(x);
        }
        System.out.println("===================================================");
        NameComparator nameComparator=new NameComparator();
        Arrays.sort(stu,nameComparator);
        for(Student2 x:stu) {
            System.out.println(x);
        }
    }
}
