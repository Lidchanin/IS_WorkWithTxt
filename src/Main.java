import java.io.IOException;

public class Main {

    private static final String path = "res/text.txt";

    public static void main(String[] args) throws IOException {
        WorkWithTxt workWithTxt = new WorkWithTxtImpl();
        workWithTxt.processingFile(path);
    }
}