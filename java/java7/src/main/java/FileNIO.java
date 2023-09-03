import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileNIO {
    public static void main(String[] args) {
        List<String> fileLines = getFileContent("test.txt");
        for (String fileLine : fileLines) {
            System.out.println(fileLine);
        }

        fileLines.add("Test");
        writeFileContent("test.txt", fileLines);
    }

    public static List<String> getFileContent(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            Path path = Paths.get(fileName);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void writeFileContent(String fileName, List<String> lines) {
        try {
            Path path = Paths.get(fileName);
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
