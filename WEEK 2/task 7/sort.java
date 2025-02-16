import java.util.ArrayList;
import java.util.Collections;

public class sort {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Yellow");
        colors.add("Green");
        Collections.sort(colors);
        System.out.println("Sorted List: " + colors);
    }
}
