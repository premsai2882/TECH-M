import java.util.LinkedList;

public class Append {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.addLast("Blue");
        System.out.println("Updated List: " + list);
    }
}
