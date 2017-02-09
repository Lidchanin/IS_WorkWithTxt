import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class work with .txt files and change them
 */
class WorkWithTxt {
    /**
     * Method parsing lines to sentences
     *
     * @param startList
     * @return finalList
     */
    private static List<String> parseOnTheSentence(List<String> startList) {
        List<String> finalList = new ArrayList<>();
        for (String aStartList : startList) {
            String[] sentences = aStartList.split("\\. |\\? |! ");
            Collections.addAll(finalList, sentences);
        }
        return finalList;
    }

    /**
     * This method reverse register in all lines
     *
     * @param allLinesList
     * @return allLinesList
     */
    private static List<String> reverseUpperLower(List<String> allLinesList) {
        for (int numSentence = 0; numSentence < allLinesList.size(); numSentence++) {
            StringBuilder stringBuilder = new StringBuilder(allLinesList.get(numSentence));
            for (int numSymbol = 0; numSymbol < stringBuilder.length(); numSymbol++) {
                char tempSymbol = stringBuilder.charAt(numSymbol);
                if (Character.isLowerCase(stringBuilder.charAt(numSymbol))) {
                    stringBuilder.setCharAt(numSymbol, Character.toUpperCase(tempSymbol));
                } else {
                    stringBuilder.setCharAt(numSymbol, Character.toLowerCase(tempSymbol));
                }
            }
            allLinesList.set(numSentence, stringBuilder.toString());
        }
        return allLinesList;
    }

    /**
     * Method reading lines of file in List, parsing this lines on the sentences, reversing his register,
     * sorting lines by length and writing lines in the same file
     *
     * @param filePath
     * @throws IOException
     */
    public static void processingFile(String filePath) throws IOException {
        List<String> allLinesList = Files.readAllLines(Paths.get(filePath));
        allLinesList = parseOnTheSentence(allLinesList);
        allLinesList = reverseUpperLower(allLinesList);
        allLinesList.sort(new ComparatorForSort());
        Files.write(Paths.get(filePath), allLinesList);
    }
}
