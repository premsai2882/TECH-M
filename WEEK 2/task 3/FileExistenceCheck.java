import java.io.File;

public class FileExistenceCheck {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        if (file.exists()) {
            System.out.println("File/Directory exists.");
        } else {
            System.out.println("File/Directory does not exist.");
        }
    }
}