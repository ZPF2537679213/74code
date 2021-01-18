package book;
public class Book {
private String name;
private String Authour;
private double price;
private int useSize;
private String type;
private int borrowNum;

    public Book(String name,String Authour,double price,int useSize,String type){
    this.name=name;
    this.Authour=Authour;
    this.price=price;
    this.useSize=useSize;
    this.type=type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名='" + name + '\'' +
                ", 作者='" + Authour + '\'' +
                ", 单价=" + price +
                ", 余量=" + useSize +
                ", 类型='" + type + '\'' +
                ", 借出量=" + borrowNum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthour() {
        return Authour;
    }

    public void setAuthour(String authour) {
        Authour = authour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUseSize() {
        return useSize;
    }

    public void setUseSize(int useSize) {
        this.useSize = useSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(int borrowNum) {
        this.borrowNum = borrowNum;
    }
}
