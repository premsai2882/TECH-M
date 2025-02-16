import java.io.File;

public class FileSizeCheck {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        if (file.exists()) {
            long bytes = file.length();
            double kb = bytes / 1024.0;
            double mb = kb / 1024.0;
            System.out.println("Size in Bytes: " + bytes);
            System.out.println("Size in KB: " + kb);
            System.out.println("Size in MB: " + mb);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
