import java.io.File;

public class FilePermissionCheck {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
