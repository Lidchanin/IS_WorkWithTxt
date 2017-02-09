/**
 * Class need to compare List elements by length
 */
class ComparatorForSort implements java.util.Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
