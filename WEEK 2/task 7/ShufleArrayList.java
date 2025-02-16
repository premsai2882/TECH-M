import java.util.ArrayList;
import java.util.Collections;

public class ShufleArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        Collections.shuffle(colors);
        System.out.println("Shuffled List: " + colors);
    }
}