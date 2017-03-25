import gradeit.*;
import org.junit.*;
import java.io.*;
import java.util.*;

//import RubricInterface.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class IntInsertionSorterTests extends GradeItTest {
    public @interface RubricItem {
        String category();
        String description();
        int value();
    }

    @RubricItem(category = "InsertionSorter", description = "empty array", value = 1)
    @Test
    public void testIntInsertionSorterEmpty() {
        int[] arr = {};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "singleton array", value = 1)
    @Test
    public void testIntInsertionSorterOne() {
        int[] arr = {1};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "array with 2 identical elements", value = 1)
    @Test
    public void testIntInsertionSorterTwoSameSorted() {
        int[] arr = {1,1};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,1}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "sorted array with 2 elements", value = 1)
    @Test
    public void testIntInsertionSorterTwoSorted() {
        int[] arr = {1,2};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "unsorted array with 2 elements", value = 1)
    @Test
    public void testIntInsertionSorterTwoUnsorted() {
        int[] arr = {2,1};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "sorted array with 3 elements", value = 1)
    @Test
    public void testIntInsertionSorterThreeSorted() {
        int[] arr = {1,2,3};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "reverse sorted array with 3 elements", value = 1)
    @Test
    public void testIntInsertionSorterThreeReverseSorted() {
        int[] arr = {3,2,1};
        Sorter s = new IntInsertionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "InsertionSorter", description = "unsorted array with 3 elements all permutations", value = 1)
    @Test
    public void testIntInsertionSorterThreeRandom() {
        int[] arr1 = {2,3,1};
        int[] arr2 = {2,1,3};
        int[] arr3 = {1,3,2};
        int[] arr4 = {3,1,2};
        Sorter s1 = new IntInsertionSorter(arr1);
        Sorter s2 = new IntInsertionSorter(arr2);
        Sorter s3 = new IntInsertionSorter(arr3);
        Sorter s4 = new IntInsertionSorter(arr4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr1);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr2);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr3);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr4);
    }

    @RubricItem(category = "InsertionSorter", description = "large random array", value = 2)
    @Test
    public void testIntInsertionSorterYUGE() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("input/intarrays.txt");
        Scanner input = new Scanner(in);
        int size = input.nextInt();
        int[] unsortedArray = new int[size];
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = input.nextInt();
        }
        for (int i = 0; i < size; i++) {
            sortedArray[i] = input.nextInt();
        }
        Sorter s = new IntInsertionSorter(unsortedArray);
        s.sort();
        Assert.assertArrayEquals(sortedArray, unsortedArray);
    }
/*
    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntInsertionSorterTests.class, 310);
    }
*/
}
