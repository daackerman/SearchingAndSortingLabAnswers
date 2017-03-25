import gradeit.*;
import org.junit.*;
import java.io.*;
import java.util.*;

//import RubricInterface.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class StringInsertionSorterTests extends GradeItTest {
    public @interface RubricItem {
        String category();
        String description();
        int value();
    }

    @RubricItem(category = "InsertionSorter", description = "empty list", value = 1)
    @Test
    public void testStringInsertionSorterEmpty() {
        List<String> list = Arrays.asList();
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList(), list);
    }

    @RubricItem(category = "InsertionSorter", description = "singleton list", value = 1)
    @Test
    public void testStringInsertionSorterOne() {
        List<String> list = Arrays.asList("a");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "list with 2 identical elements", value = 1)
    @Test
    public void testStringInsertionSorterTwoSameSorted() {
        List<String> list = Arrays.asList("a", "a");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "a"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "sorted list with 2 elements", value = 1)
    @Test
    public void testStringInsertionSorterTwoSorted() {
        List<String> list = Arrays.asList("a", "b");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "unsorted list with 2 elements", value = 1)
    @Test
    public void testStringInsertionSorterTwoUnsorted() {
        List<String> list = Arrays.asList("b", "a");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "sorted list with 3 elements", value = 1)
    @Test
    public void testStringInsertionSorterThreeSorted() {
        List<String> list = Arrays.asList("a", "b", "c");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "reverse sorted list with 3 elements", value = 1)
    @Test
    public void testStringInsertionSorterThreeReverseSorted() {
        List<String> list = Arrays.asList("c", "b", "a");
        Sorter s = new StringInsertionSorter(list);
        s.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list);
    }

    @RubricItem(category = "InsertionSorter", description = "unsorted list with 3 elements all permutations", value = 1)
    @Test
    public void testStringInsertionSorterThreeRandom() {
        List<String> list1 = Arrays.asList("b", "c", "a");
        List<String> list2 = Arrays.asList("b", "a", "c");
        List<String> list3 = Arrays.asList("c", "a", "b");
        List<String> list4 = Arrays.asList("a", "c", "b");
        Sorter s1 = new StringInsertionSorter(list1);
        Sorter s2 = new StringInsertionSorter(list2);
        Sorter s3 = new StringInsertionSorter(list3);
        Sorter s4 = new StringInsertionSorter(list4);
        s1.sort();
        s2.sort();
        s3.sort();
        s4.sort();
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list1);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list2);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list3);
        Assert.assertEquals(Arrays.asList("a", "b", "c"), list4);
    }

    @RubricItem(category = "InsertionSorter", description = "large random list", value = 2)
    @Test
    public void testStringInsertionSorterYUGE() throws FileNotFoundException {
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
        Sorter s = new StringInsertionSorter(unsortedList);
        s.sort();
        Assert.assertEquals(sortedList, unsortedList);
    }
/*
    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(StringInsertionSorterTests.class, 340);
    }
*/
}
