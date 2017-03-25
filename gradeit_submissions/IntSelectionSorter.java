/**
 * This class has methods to sort an array of integers. It implements the selection sort algorithm to sort the array.
 *
 * Example run of selection sort:
 * 64 25 12 22 11 // this is the initial, starting state of the array
 * 11 25 12 22 64 // sorted sublist = {11}
 * 11 12 25 22 64 // sorted sublist = {11, 12}
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22}
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25}
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}
 *
 * TODO implement sort method
 */
public class IntSelectionSorter implements Sorter {
    private int[] arr;

    /**
     * Constructor for the IntSelectionSorter. It takes a passed array and points its
     * internal parameter arr at the passed array. Any operations performed on arr will be
     * performed on the passed array.
     * @param arr the array to be sorted.
     */
    public IntSelectionSorter(int[] arr) {
        this.arr = arr;
    }

    /**
     * Implements the selection sort algorithm on the member variable, arr.
     */
    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            int minPos = minPosition(i, arr.length);
            ArrayUtils.swap(arr, i, minPos);
        }
    }

    /**
     * Helper method to determine the position of the smallest element in the range
     * [i, j - 1].
     * @param i smallest possible index
     * @param j 1 more than largest possible index
     * @return the index of the minimum element in between [i, j - 1]
     */
    private int minPosition(int i, int j) {
        int minPos = i;
        int min = arr[minPos];
        for (int k = i; k < j; k++) {
            if (arr[k] < min) {
                min = arr[k];
                minPos = k;
            }
        }
        return minPos;
    }
}
