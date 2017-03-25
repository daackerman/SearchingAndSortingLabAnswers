/**
 * This interface represents classes that have search methods such as contains and indexOf.
 */
public interface Searcher {
    /**
     * Determines if the target value is in the array.
     * @param target value to search for
     * @return true if target is in the array
     *         false otherwise.
     */
    boolean contains(Object target);

    /**
     * Determines the first index of the target value in the array.
     * @param target value to search for
     * @return an index if the target is in the array
     *         -1 otherwise.
     */
    int indexOf(Object target);
}
