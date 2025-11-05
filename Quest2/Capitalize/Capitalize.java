import java.io.*;
public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        String text = content.toString().trim();
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(result.toString());
        writer.close();
    }
}
