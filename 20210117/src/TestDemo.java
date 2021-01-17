

class Money implements Cloneable{
    public int money;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public  String name;
    public  int age;
    public Money money=new Money();
    public Person(String name){
        this.name=name;
    }
    public Person(int age){
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money.money +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person=(Person)super.clone();
        person.money=(Money) this.money.clone();
        return person;
    }
}
public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person =new Person("zhangsan");
        System.out.println(person);
        Person person2=(Person)person.clone();
        System.out.println(person2);
        System.out.println("===============================================");
        person2.age=18;
        person.money.money=18;
        System.out.println(person);
        System.out.println(person2);

    }
}