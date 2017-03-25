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
public class StringSelectionSorterTests extends GradeItTest {
    @RubricItem(category = "SelectionSorter", description = "empty list", value = 1)
    @Test
    public void testStringSelectionSorterEmpty() {
        List<String> list = Arrays.asList();
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList(), list);
    }

    @RubricItem(category = "SelectionSorter", description = "singleton list", value = 1)
    @Test
    public void testStringSelectionSorterOne() {
        List<String> list = Arrays.asList("a");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "list with 2 identical elements", value = 1)
    @Test
    public void testStringSelectionSorterTwoSameSorted() {
        List<String> list = Arrays.asList("a", "a");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "a"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "sorted list with 2 elements", value = 1)
    @Test
    public void testStringSelectionSorterTwoSorted() {
        List<String> list = Arrays.asList("a", "b");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "unsorted list with 2 elements", value = 1)
    @Test
    public void testStringSelectionSorterTwoUnsorted() {
        List<String> list = Arrays.asList("b", "a");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "sorted list with 3 elements", value = 1)
    @Test
    public void testStringSelectionSorterThreeSorted() {
        List<String> list = Arrays.asList("a", "b", "c");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "reverse sorted list with 3 elements", value = 1)
    @Test
    public void testStringSelectionSorterThreeReverseSorted() {
        List<String> list = Arrays.asList("c", "b", "a");
        Sorter s = new StringSelectionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "SelectionSorter", description = "unsorted list with 3 elements all permutations", value = 1)
    @Test
    public void testStringSelectionSorterThreeRandom() {
        List<String> list1 = Arrays.asList("b", "c", "a");
        List<String> list2 = Arrays.asList("b", "a", "c");
        List<String> list3 = Arrays.asList("c", "a", "b");
        List<String> list4 = Arrays.asList("a", "c", "b");
        Sorter s1 = new StringSelectionSorter(list1);
        Sorter s2 = new StringSelectionSorter(list2);
        Sorter s3 = new StringSelectionSorter(list3);
        Sorter s4 = new StringSelectionSorter(list4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list1);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list2);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list3);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list4);
    }

    @RubricItem(category = "SelectionSorter", description = "large random list", value = 2)
    @Test
    public void testStringSelectionSorterYUGE() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("res/stringlists.txt");
        Scanner input = new Scanner(in);
        int size = input.nextInt();
        List<String> unsortedList = new ArrayList<String>();
        List<String> sortedList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            unsortedList.add(input.next());
        }
        for (int i = 0; i < size; i++) {
            sortedList.add(input.next());
        }
        Sorter s = new StringSelectionSorter(unsortedList);
        s.sort();
        Assert.assertEquals(sortedList, unsortedList);
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(StringSelectionSorterTests.class, 340);
    }
}
