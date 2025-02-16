import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // Change this path as needed
        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            System.out.println("Files and Directories in " + dir.getAbsolutePath() + ":");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}