import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class work with .txt and .json files and change them
 */
class WorkWithTxtImpl implements WorkWithTxt{

    /**
     * Method parsing lines to sentences
     *
     * @param startList list of lines
     * @return list of sentences
     */
    List<String> parseOnTheSentence(List<String> startList) {
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
     * @param allLinesList list of sentences or lines
     * @return list of sentences with reversed register
     */
    List<String> reverseUpperLower(List<String> allLinesList) {
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

    public void processingFile(String filePath) {
        try {
            List<String> allLinesList = Files.readAllLines(Paths.get(filePath));
            allLinesList = parseOnTheSentence(allLinesList);
            allLinesList = reverseUpperLower(allLinesList);
            allLinesList.sort(new ComparatorForSort());
            Files.write(Paths.get(filePath), allLinesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
