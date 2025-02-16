import java.util.LinkedList;

public class InsertAtFront {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Green");
        list.add("Blue");
        list.addFirst("Red");
        System.out.println("Updated List: " + list);
    }
}