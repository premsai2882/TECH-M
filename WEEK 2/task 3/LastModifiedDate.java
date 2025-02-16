import java.io.File;
import java.util.Date;

public class LastModifiedDate {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        if (file.exists()) {
            System.out.println("Last modified: " + new Date(file.lastModified()));
        } else {
            System.out.println("File does not exist.");
        }
    }
}