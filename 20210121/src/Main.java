import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
class Student {
    public String name;
    public String number;
    public int course;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", course=" + course +
                '}';
    }
}
public class Main{
    public static void main(String[]args){
        List<Student> arrayList=new ArrayList<>();
        Student stu=new Student();
        stu.name="hahaha";
        stu.number="1111111";
        stu.course=111;
        arrayList.add(stu);
        Student stu2=new Student();
        stu2.name="lalalala";
        stu2.number="222222";
        stu2.course=222;
        arrayList.add(stu2);
        System.out.println(arrayList);
        Iterator iterator=arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(arrayList.get(0));
    }
}

