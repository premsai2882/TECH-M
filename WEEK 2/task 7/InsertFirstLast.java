import java.util.LinkedList;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Green");
        list.addFirst("Red");
        list.addLast("Blue");
        System.out.println("Updated List: " + list);
    }
}
