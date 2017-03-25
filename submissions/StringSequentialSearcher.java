package searchers;

import java.util.List;

/**
 * This class has methods for searching an list of Strings for a particular String. It uses the sequential search
 * algorithm to find the position of the element if it exists.
 *
 * TODO Implement contains and indexOf methods
 */
public class StringSequentialSearcher implements Searcher {
    private List<String> list;

    public StringSequentialSearcher(List<String> list) {
        this.list = list;
    }

    /**
     * Determines if the target value is in the array.
     * @param target String to search for
     * @return true if target is in the array
     *         false otherwise.
     */
    @Override
    public boolean contains(Object target) {
        return indexOf(target) != -1;
    }

    /**
     * Determines the first index of the target String in the array.
     * @param target String to search for
     * @return an index if the target is in the array
     *         -1 otherwise.
     */
    @Override
    public int indexOf(Object target) {
        if (!(target instanceof String)) {
            throw new IllegalArgumentException("target is wrong class: " + target.getClass());
        }
        String t = (String)target;
        for (int i = 0; i < list.size(); i++) {
            if (t.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
