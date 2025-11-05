import java.io.File;
public class FileSearch {
    public static String searchFile(String fileName) {
        File root = new File("documents");
        return search(root, fileName);
    }
    static String search(File folder, String fileName) {
        if (!folder.exists() || !folder.isDirectory()) return null;
        for (File f : folder.listFiles()) {
            if (f.isFile() && f.getName().equals(fileName)) {
                return f.getPath();
            }
            if (f.isDirectory()) {
                String found = search(f, fileName);
                if (found != null) return found;
            }
        }
        return null;
    }
}
