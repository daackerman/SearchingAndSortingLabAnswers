import gradeit.*;
import org.junit.*;
import java.io.*;
import java.util.*;

//import RubricInterface.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class IntBubbleSorterTests extends GradeItTest {
    public @interface RubricItem {
        String category();
        String description();
        int value();
    }

    @RubricItem(category = "BubbleSorter", description = "empty array", value = 1)
    @Test
    public void testIntBubbleSorterEmpty() {
        int[] arr = {};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "singleton array", value = 1)
    @Test
    public void testIntBubbleSorterOne() {
        int[] arr = {1};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "array with 2 identical elements", value = 1)
    @Test
    public void testIntBubbleSorterTwoSameSorted() {
        int[] arr = {1,1};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,1}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "sorted array with 2 elements", value = 1)
    @Test
    public void testIntBubbleSorterTwoSorted() {
        int[] arr = {1,2};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "unsorted array with 2 elements", value = 1)
    @Test
    public void testIntBubbleSorterTwoUnsorted() {
        int[] arr = {2,1};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "sorted array with 3 elements", value = 1)
    @Test
    public void testIntBubbleSorterThreeSorted() {
        int[] arr = {1,2,3};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "reverse sorted array with 3 elements", value = 1)
    @Test
    public void testIntBubbleSorterThreeReverseSorted() {
        int[] arr = {3,2,1};
        Sorter s = new IntBubbleSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "BubbleSorter", description = "unsorted array with 3 elements all permutations", value = 1)
    @Test
    public void testIntBubbleSorterThreeRandom() {
        int[] arr1 = {2,3,1};
        int[] arr2 = {2,1,3};
        int[] arr3 = {1,3,2};
        int[] arr4 = {3,1,2};
        Sorter s1 = new IntBubbleSorter(arr1);
        Sorter s2 = new IntBubbleSorter(arr2);
        Sorter s3 = new IntBubbleSorter(arr3);
        Sorter s4 = new IntBubbleSorter(arr4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr1);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr2);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr3);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr4);
    }

    @RubricItem(category = "BubbleSorter", description = "large random array", value = 2)
    @Test
    public void testIntBubbleSorterYUGE() throws FileNotFoundException {
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
        Sorter s = new IntBubbleSorter(unsortedArray);
        s.sort();
        Assert.assertArrayEquals(sortedArray, unsortedArray);
    }
/*
    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntBubbleSorterTests.class, 300);
    }
*/
}
