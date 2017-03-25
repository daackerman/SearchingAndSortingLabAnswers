/**
 * This class has methods for sorting an array of integers using the bubble sort algorithm.
 *
 * Example run of bubble sort:
 * 64 25 12 22 11 // this is the initial, starting state of the array
 * 25 64 12 22 11 // swap 64 and 25
 * 25 12 64 22 11 // swap 64 and 12
 * 25 12 22 64 11 // swap 64 and 22
 * 25 12 22 11 64 // swap 64 and 11
 * 12 25 22 11 64 // swap 25 and 12
 * 12 22 25 11 64 // swap 25 and 22
 * 12 22 11 25 64 // swap 25 and 11
 * 12 22 11 25 64 // don't swap 12 and 22
 * 12 11 22 25 64 // swap 22 and 11
 * 11 12 22 25 64 // swap 12 and 11 and finished
 *
 * TODO implement sort method
 */
public class IntBubbleSorter implements Sorter {
    private int[] arr;

    /**
     * Constructor for the IntBubbleSorter. It takes a passed array and points its
     * internal parameter arr at the passed array. Any operations performed on arr will be
     * performed on the passed array.
     * @param arr the array to be sorted.
     */
    public IntBubbleSorter(int[] arr) {
        this.arr = arr;
    }

    /**
     * Implements the bubble sort algorithm on the member variable, arr.
     */
    @Override
    public void sort() {
        boolean swapped = true;
        int n = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[i + 1]) {
                    ArrayUtils.swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            n -= 1;
        }
    }
}
