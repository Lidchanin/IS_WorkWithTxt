import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> allLinesList = Files.readAllLines(Paths.get("res/text.txt"));
        allLinesList = WorkWithTxt.parseOnTheOffer(allLinesList);
        allLinesList = WorkWithTxt.reverseUpperLower(allLinesList);
        allLinesList.sort(new ComparatorForSort());
        Files.write(Paths.get("res/text.txt"), allLinesList);
    }
}