import java.io.File;

/**
 * Quinn Epstein
 */
public class FileSearch {
    public static void main(String[] args) {
        System.out.println(searchFiles(new File("q:\\"), "readme.txt"));
        System.out.println(recursiveSearch(new File("q:\\"), "readme.txt"));

    }

    public static String searchFiles(File path, String target) {
        if (!path.isDirectory()) {
            return "Not found";
        }

        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(target)) {
                    return "Found: " + file.getAbsolutePath();
                } else if (file.isDirectory()) {
                    String result = searchFiles(file, target);
                    if (!result.equals("Not found")) {
                        return result;
                    }
                }
            }
        }
        return "Not found";
    }
    public static String recursiveSearch(File path, String target) {
        if (!path.isDirectory()) {
            return "Not found";
        }

        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(target)) {
                    return "Found: " + file.getAbsolutePath();
                } else if (file.isDirectory()) {
                    String result = recursiveSearch(file, target);
                    if (!result.equals("Not found")) {
                        return result;
                    }
                }
            }
        }
        return "Not found";
    }
}
