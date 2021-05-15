/**
 * @author:飞哥
 * @date: 2021/4/23 14:36
 */
public class Main {

}
 class Test {
    public static void main(String [] args){
        System.out.println(new B().getValue());
        String str="Hello*hhhh";
        java.util.HashMap map=new java.util.HashMap();
        map.put("gg","hh");
        map.put("uu","uu");
        System.out.println(map.size());
    }
    static class A{
        protected int value;
        public A(int v) {
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try{
                value++;
                return value;
            } catch(Exception e){
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{
        public B() {
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int value){
            super.setValue(2 * value);
        }
    }
}

