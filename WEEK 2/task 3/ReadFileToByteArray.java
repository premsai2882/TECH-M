import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileToByteArray {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Public\\test.txt"); // Change path
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            System.out.println("File Read into Byte Array.");
        } else {
            System.out.println("File does not exist.");
        }
    }
}
