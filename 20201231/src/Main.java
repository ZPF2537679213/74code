
public class Main {
    public static void main(String[] args) {
      MyLinkList h=new MyLinkList();
      h.endInsert(8);
      h.endInsert(18);
      h.headInsert(8);
      h.headInsert(38);
      h.headInsert(8);
      h.headInsert(8);
      h.deleted2(8);
      h.display(h.head);
      h.iLink1();
      h.display(h.head);
    }
}
