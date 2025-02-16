p import java.util.Arrays;import java.util.List;
public class CountStartingLetter {
public static void main(String[] args) {
List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry",
"avocado", "blueberry");
char specificLetter = 'a';
long count = words.stream()
.filter(word-> word.startsWith(String.valueOf(specificLetter)))
.count();
System.out.println("Number of words starting with '" + specificLetter + "': " +
count);
}
}