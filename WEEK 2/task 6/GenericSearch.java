import java.util.List;

public class GenericSearch {
    public static <T> int findElementIndex(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Banana", "Cherry", "Date");
        System.out.println("Index of 'Cherry': " + findElementIndex(words, "Cherry"));
        System.out.println("Index of 'Grapes': " + findElementIndex(words, "Grapes"));
    }
}