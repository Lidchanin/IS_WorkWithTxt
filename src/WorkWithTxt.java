import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WorkWithTxt {
    static List<String> parseOnTheOffer(List<String> startList) {
        List<String> finalList = new ArrayList<>();
        for (String aStartList : startList) {
            String[] offers = aStartList.split("\\. ");
            Collections.addAll(finalList, offers);
        }
        return finalList;
    }

    static List<String> reverseUpperLower(List<String> startList) {
        List<String> finalList = new ArrayList<>();
        for (int numOffer = 0; numOffer < startList.size(); numOffer++) {
            StringBuilder stringBuilder = new StringBuilder(startList.get(numOffer));
            for (int numSymbol = 0; numSymbol < stringBuilder.length(); numSymbol++) {
                char tempSymbol = stringBuilder.charAt(numSymbol);
                if (Character.isLowerCase(stringBuilder.charAt(numSymbol))) {
                    stringBuilder.setCharAt(numSymbol, Character.toUpperCase(tempSymbol));
                } else {
                    stringBuilder.setCharAt(numSymbol, Character.toLowerCase(tempSymbol));
                }
            }
            finalList.add(stringBuilder.toString());
//            System.out.println(startList.get(numOffer));
//            System.out.println(stringBuilder.toString());
        }
        return finalList;
    }
}
