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
public class StringBubbleSorterTests extends GradeItTest {
    @RubricItem(category = "BubbleSorter", description = "empty list", value = 1)
    @Test
    public void testStringBubbleSorterEmpty() {
        List<String> list = Arrays.asList();
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList(), list);
    }

    @RubricItem(category = "BubbleSorter", description = "singleton list", value = 1)
    @Test
    public void testStringBubbleSorterOne() {
        List<String> list = Arrays.asList("a");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "list with 2 identical elements", value = 1)
    @Test
    public void testStringBubbleSorterTwoSameSorted() {
        List<String> list = Arrays.asList("a", "a");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "a"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "sorted list with 2 elements", value = 1)
    @Test
    public void testStringBubbleSorterTwoSorted() {
        List<String> list = Arrays.asList("a", "b");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "unsorted list with 2 elements", value = 1)
    @Test
    public void testStringBubbleSorterTwoUnsorted() {
        List<String> list = Arrays.asList("b", "a");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "sorted list with 3 elements", value = 1)
    @Test
    public void testStringBubbleSorterThreeSorted() {
        List<String> list = Arrays.asList("a", "b", "c");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "reverse sorted list with 3 elements", value = 1)
    @Test
    public void testStringBubbleSorterThreeReverseSorted() {
        List<String> list = Arrays.asList("c", "b", "a");
        Sorter s = new StringBubbleSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "BubbleSorter", description = "unsorted list with 3 elements all permutations", value = 1)
    @Test
    public void testStringBubbleSorterThreeRandom() {
        List<String> list1 = Arrays.asList("b", "c", "a");
        List<String> list2 = Arrays.asList("b", "a", "c");
        List<String> list3 = Arrays.asList("c", "a", "b");
        List<String> list4 = Arrays.asList("a", "c", "b");
        Sorter s1 = new StringBubbleSorter(list1);
        Sorter s2 = new StringBubbleSorter(list2);
        Sorter s3 = new StringBubbleSorter(list3);
        Sorter s4 = new StringBubbleSorter(list4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list1);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list2);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list3);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list4);
    }

    @RubricItem(category = "BubbleSorter", description = "large random list", value = 2)
    @Test
    public void testStringBubbleSorterYUGE() throws FileNotFoundException {
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
        Sorter s = new StringBubbleSorter(unsortedList);
        s.sort();
        Assert.assertEquals(sortedList, unsortedList);
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(StringBubbleSorterTests.class, 330);
    }
}
