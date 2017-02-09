/**
 * Interface work with .txt or .json files and change them:
 * 1. Reading all lines in your file;
 * 2. Reversing all letter register;
 * 3. Parsing all text to separated sentences;
 * 4. Sorts sentences ascending length
 * 5. Writing refactored text in your file.
 */
public interface WorkWithTxt {
    /**
     * Method reading lines of file in List, parsing this lines on the sentences, reversing his register,
     * sorting lines by length and writing lines in the same file
     *
     * @param filePath this parameter containing path to your file.txt or file.json
     */
    void processingFile(String filePath);
}