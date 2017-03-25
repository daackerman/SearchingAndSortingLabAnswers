package SorterTests;

import RubricInterface.RubricDumper;
import RubricInterface.RubricItem;
import org.junit.Assert;
import org.junit.Test;
import sorters.*;

import java.io.*;
import java.util.*;
import gradeit.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class IntSelectionSorterTests extends GradeItTest {
    @RubricItem(category = "SelectionSorter", description = "empty array", value = 1)
    @Test
    public void testIntSelectionSorterEmpty() {
        int[] arr = {};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "singleton array", value = 1)
    @Test
    public void testIntSelectionSorterOne() {
        int[] arr = {1};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "array with 2 identical elements", value = 1)
    @Test
    public void testIntSelectionSorterTwoSameSorted() {
        int[] arr = {1,1};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,1}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "sorted array with 2 elements", value = 1)
    @Test
    public void testIntSelectionSorterTwoSorted() {
        int[] arr = {1,2};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "unsorted array with 2 elements", value = 1)
    @Test
    public void testIntSelectionSorterTwoUnsorted() {
        int[] arr = {2,1};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "sorted array with 3 elements", value = 1)
    @Test
    public void testIntSelectionSorterThreeSorted() {
        int[] arr = {1,2,3};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "reverse sorted array with 3 elements", value = 1)
    @Test
    public void testIntSelectionSorterThreeReverseSorted() {
        int[] arr = {3,2,1};
        Sorter s = new IntSelectionSorter(arr);
        s.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @RubricItem(category = "SelectionSorter", description = "unsorted array with 3 elements all permutations", value = 1)
    @Test
    public void testIntSelectionSorterThreeRandom() {
        int[] arr1 = {2,3,1};
        int[] arr2 = {2,1,3};
        int[] arr3 = {1,3,2};
        int[] arr4 = {3,1,2};
        Sorter s1 = new IntSelectionSorter(arr1);
        Sorter s2 = new IntSelectionSorter(arr2);
        Sorter s3 = new IntSelectionSorter(arr3);
        Sorter s4 = new IntSelectionSorter(arr4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertArrayEquals(new int[]{1,2,3}, arr1);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr2);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr3);
        Assert.assertArrayEquals(new int[]{1,2,3}, arr4);
    }

    @RubricItem(category = "SelectionSorter", description = "large random array", value = 2)
    @Test
    public void testIntSelectionSorterYUGE() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("res/intarrays.txt");
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
        Sorter s = new IntSelectionSorter(unsortedArray);
        s.sort();
        Assert.assertArrayEquals(sortedArray, unsortedArray);
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntSelectionSorterTests.class, 320);
    }
}
