import java.io.File;
import java.io.FilenameFilter;

public class GetSpecificFiles {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // Change path
        String extension = ".txt"; // Change extension as needed
        FilenameFilter filter = (f, name) -> name.endsWith(extension);
        File[] files = dir.listFiles(filter);
        System.out.println("Files with extension " + extension + ":");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
