import java.io.*;
public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        FileOutputStream outFile = new FileOutputStream(args[0]);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = System.in.read(buffer)) != -1) {
            outFile.write(buffer, 0, bytesRead);
        }
    }
}
