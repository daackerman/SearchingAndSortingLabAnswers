package sorters;

import java.util.List;

/**
 * This class has methods to sort a List of Strings. It uses the insertion sort algorithm and String's compareTo
 * method to sort the Strings in lexicographical order.
 *
 * TODO implement sort method
 */
public class StringInsertionSorter implements Sorter {
    private List<String> list;

    /**
     * Constructor for StringInsertionSorter
     * @param l the list to sort
     */
    public StringInsertionSorter(List<String> l) {
        list = l;
    }

    /**
     * Sorts this list according to the insertion sort algorithm.
     */
    @Override
    public void sort() {
        for (int i = 1; i < list.size(); i++) {
            String current = list.get(i);
            int index = i;
            while (index > 0 && current.compareTo(list.get(index - 1)) < 0) {
                list.set(index, list.get(index - 1));
                index--;
            }
            list.set(index, current);
        }
    }
}
