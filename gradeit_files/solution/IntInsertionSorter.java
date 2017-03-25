/**
 * This class has methods to sort an array of integers. It implements the insertion sort algorithm to sort the array.
 *
 * Example run of insertion sort:
 * 64 25 12 22 11 // this is the initial, starting state of the array
 * 25 64 12 22 11 // sorted sublist = {25, 64}
 * 12 25 64 22 11 // sorted sublist = {12, 25, 64}
 * 12 22 25 64 11 // sorted sublist = {12, 22, 25, 64}
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}
 *
 * TODO implement sort method
 */
public class IntInsertionSorter implements Sorter {
    private int[] arr;

    /**
     * Constructor for the IntInsertionSorter. It takes a passed array and points its
     * internal parameter arr at the passed array. Any operations performed on arr will be
     * performed on the passed array.
     * @param arr the array to be sorted.
     */
    public IntInsertionSorter(int[] arr) {
        this.arr = arr;
    }

    /**
     * Implements the insertion sort algorithm on the member variable, arr.
     */
    @Override
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            //while there are elements to look at and the current is less than the element before it
            while (index > 0 && current < arr[index - 1]) {
                //move the element to the right and decrement index
                arr[index] = arr[index - 1];
                index--;
            }
            //insert current into the index
            arr[index] = current;
        }
    }
}
