package sorters;

import java.util.List;
import tools.ArrayUtils;

/**
 * This class has methods to sort a List of Strings. It uses the selection sort algorithm and String's compareTo
 * method to sort the Strings in lexicographical order.
 *
 * TODO implement sort method
 */
public class StringSelectionSorter implements Sorter {
    private List<String> list;

    /**
     * Constructor for the StringSelectionSorter.
     * @param l the list to sort.
     */
    public StringSelectionSorter(List<String> l) {
        list = l;
    }

    /**
     * Sorts this list according to the selection sort algorithm.
     */
    @Override
    public void sort() {
        for (int i = 0; i < list.size(); i++) {
            int minPos = minPosition(i, list.size());
            ArrayUtils.swap(list, i, minPos);
        }
    }

    /**
     * Determines the index of the first String using lexicographical ordering in list between i and j - 1.
     * @param i smallest possible index
     * @param j 1 more than largest possible index
     * @return the position of the first String
     */
    private int minPosition(int i, int j) {
        String first = list.get(i);
        int index = i;
        for (int k = i; k < j; k++) {
            String current = list.get(k);
            if (current.compareTo(first) < 0) {
                first = current;
                index = k;
            }
        }
        return index;
    }
}
