import java.util.*;

/**
 * This class has methods to sort a List of Strings. It uses the bubble sort algorithm and String's compareTo
 * method to sort the Strings in lexicographical order.
 *
 * TODO implement sort method
 */
public class StringBubbleSorter implements Sorter{
    private List<String> list;

    /**
     * Constructor for StringBubbleSorter
     * @param l the list to sort
     */
    public StringBubbleSorter(List<String> l) {
        list = l;
    }

    @Override
    public void sort() {
        boolean swapped = true;
        int n = list.size() - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                    ArrayUtils.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            n -= 1;
        }
    }
}
