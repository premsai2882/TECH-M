public class StringProcessor {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static String splitAndCapitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String str = "hello world";
        String text = "This is a test. This is only a test.";
        String sub = "test";

        System.out.println("Reversed string: " + reverseString(str));
        System.out.println("Occurrences of 'test': " + countOccurrences(text, sub));
        System.out.println("Split and capitalized: " + splitAndCapitalize(str));
    }
}
