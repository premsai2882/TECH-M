import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadPlainTextFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Public\\test.txt"; // Change path
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("File Content:\n" + content);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
