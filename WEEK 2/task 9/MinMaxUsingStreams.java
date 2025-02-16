import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 8, 50, 15);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        max.ifPresent(value -> System.out.println("Maximum Value: " + value));
        min.ifPresent(value -> System.out.println("Minimum Value: " + value));
    }
}