import java.io.File;
import java.io.FileNotFoundException;

class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class EmptyFileCheck {
    public static void checkEmptyFile(String filePath) throws FileNotFoundException,
            EmptyFileException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        if (file.length() == 0) {
            throw new EmptyFileException("File is empty: " + filePath);
        }
        System.out.println("File is not empty.");
    }

    public static void main(String[] args) {
        try {
            checkEmptyFile("C:\\Users\\Public\\test.txt"); // Change path
        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
