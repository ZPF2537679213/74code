
import java.util.Arrays;
class Student implements Comparable<Student>{
    public String name;
    public int age;
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Student(){

    }
    public Student(String name,int age){
        this.age=age;
        this.name=name;
    }
    @Override
    public int compareTo(Student o) {
       return  this.age-o.age;
    }
}
public class MyComparable {
    public static void main(String[] args) {
        Student[]stu=new Student[]{new Student("zhangsan",38),new Student("lisi",20),new Student("wangmazi",30)};
        for(Student x:stu){
            System.out.println(x);
        }
        Arrays.sort(stu);
        for(Student x:stu){
            System.out.println(x);
        }
    }
}
