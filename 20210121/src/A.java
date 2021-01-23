public class A<T> {
    T value;

    A(T value) {
        this.value=value;
    }

    T get() {
        return this.value;
    }
}
class Main2{
    public static void main(String[] args) {
        A<String> a=new A<>("hhahahahaha");
        String str=a.get();
        System.out.println(str);
    }
}