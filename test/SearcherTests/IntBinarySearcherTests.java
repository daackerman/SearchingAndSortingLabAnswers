package SearcherTests;

import RubricInterface.RubricDumper;
import RubricInterface.RubricItem;
import gradeit.*;
import org.junit.Assert;
import org.junit.Test;
import searchers.IntBinarySearcher;
import searchers.Searcher;

/**
 * Created by daackerman on 3/21/2017.
 */
public class IntBinarySearcherTests extends GradeItTest{
    @RubricItem(category = "indexOf", description = "empty array returns -1", value = 1)
    @Test
    public void testIndexOfIBSEmpty() {
        int[] arr = {};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(-1, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "singleton array returns 0 if there", value = 1)
    @Test
    public void testIndexOfIBSOneFound() {
        int[] arr = {1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(0, s.indexOf(1));
    }

    @RubricItem(category = "indexOf", description = "singleton array returns -1 if not there", value = 1)
    @Test
    public void testIndexOfIBSOneNotFound() {
        int[] arr = {1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(-1, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "array of two elements can return second index", value = 1)
    @Test
    public void testIndexOfIBSTwoFound() {
        int[] arr = {1, 2};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(1, s.indexOf(2));
    }

    @RubricItem(category = "indexOf", description = "array of two elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfIBSTwoNotFound() {
        int[] arr = {1, 2};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(-1, s.indexOf(3));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns 0 for first item", value = 1)
    @Test
    public void testIndexOfIBSManyFoundBeginning() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(0, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns middle for middle item", value = 1)
    @Test
    public void testIndexOfIBSManyFoundMiddle() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(50, s.indexOf(50));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns last index for last item", value = 1)
    @Test
    public void testIndexOfIBSManyFoundEnd() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(99, s.indexOf(99));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns each index for each item", value = 1)
    @Test
    public void testIndexOfIBSManyFoundAll() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntBinarySearcher(arr);
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, s.indexOf(i));
        }
    }
    
    @RubricItem(category = "indexOf", description = "array of many elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfIBSManyNotFound() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertEquals(-1, s.indexOf(100));
    }

    //Begin Binary Searcher Contains Tests
    @RubricItem(category = "contains", description = "empty array returns false", value = 1)
    @Test
    public void testContainsIBSEmptyFalse() {
        int[] arr = {};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertFalse(s.contains(0));
    }

    @RubricItem(category = "contains", description = "returns true for first item", value = 1)
    @Test
    public void testContainsIBSBeginning() {
        int[] arr = {-3,-2,-1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertTrue(s.contains(-3));
    }

    @RubricItem(category = "contains", description = "returns true for middle item", value = 1)
    @Test
    public void testContainsIBSMiddle() {
        int[] arr = {-3,-2,-1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertTrue(s.contains(-2));
    }

    @RubricItem(category = "contains", description = "returns true for last item", value = 1)
    @Test
    public void testContainsIBSEnd() {
        int[] arr = {-3,-2,-1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertTrue(s.contains(-1));
    }

    @RubricItem(category = "contains", description = "returns false for item not in list", value = 1)
    @Test
    public void testContainsIBSFalse() {
        int[] arr = {-3,-2,-1};
        Searcher s = new IntBinarySearcher(arr);
        Assert.assertFalse(s.contains(1));
    }

    @RubricItem(category = "contains", description = "returns true for many items in a list", value = 1)
    @Test
    public void testContainsIBSManyTrue() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }
        Searcher s = new IntBinarySearcher(arr);
        for (int i = 0; i < 200; i += 2) {
            Assert.assertTrue(s.contains(i));
        }
    }

    @RubricItem(category = "contains", description = "returns false for many items not in a list", value = 1)
    @Test
    public void testContainsIBSManyFalse() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }
        Searcher s = new IntBinarySearcher(arr);
        for (int i = 1; i < 202; i += 2) {
            Assert.assertFalse(s.contains(i));
        }
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntBinarySearcherTests.class, 220);
    }
}
