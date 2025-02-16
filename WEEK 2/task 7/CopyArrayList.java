import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyArrayList {
    public static void main(String[] args) {
        List<String> sourceList = List.of("Red", "Green", "Blue");
        ArrayList<String> destList = new ArrayList<>(sourceList);
        System.out.println("Copied List: " + destList);
    }
}