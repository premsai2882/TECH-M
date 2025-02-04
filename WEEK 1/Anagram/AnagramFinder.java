import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramFinder {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLength = p.length();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i <= s.length() - pLength; i++) {
            String substring = s.substring(i, i + pLength);
            char[] subArray = substring.toCharArray();
            Arrays.sort(subArray);
            if (Arrays.equals(pArray, subArray)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("Start indices of anagrams: " + anagrams);
    }
}
