import java.util.ArrayList;

public class updateelement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.set(1, "Yellow");
        System.out.println("Updated List: " + colors);
    }
}
