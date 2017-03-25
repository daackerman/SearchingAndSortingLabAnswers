/**
 * This class has methods for searching an array of integers for a particular value. It uses the sequential search
 * algorithm to find the position of the element if it exists.
 *
 * TODO Implement contains and indexOf methods
 */
public class IntSequentialSearcher implements Searcher {
    private int[] arr;

    public IntSequentialSearcher(int[] arr) {
        this.arr = arr;
    }

    /**
     * Determines if the target value is in the array.
     * @param target value to search for
     * @return true if target is in the array
     *         false otherwise.
     */
    @Override
    public boolean contains(Object target) {
        return indexOf(target) != -1;
    }

    /**
     * Determines the first index of the target value in the array.
     * @param target value to search for
     * @return an index if the target is in the array
     *         -1 otherwise.
     */
    @Override
    public int indexOf(Object target) {
        if (!(target instanceof Integer)) {
            throw new IllegalArgumentException("target is wrong class: " + target.getClass());
        }
        int t = (Integer)target;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }
}
