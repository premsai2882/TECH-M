import java.io.File;

public class CheckFileOrDirectory {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        if (file.isFile()) {
            System.out.println("It is a file.");
        } else if (file.isDirectory()) {
            System.out.println("It is a directory.");
        } else {
            System.out.println("Invalid path.");
        }
    }
}