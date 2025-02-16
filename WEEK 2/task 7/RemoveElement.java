import java.util.ArrayList;

public class RemoveElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.remove(2);
        System.out.println("Updated List: " + colors);
    }
}