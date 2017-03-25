import gradeit.*;
import org.junit.*;

//import RubricInterface.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class IntSequentialSearcherTests extends GradeItTest {
    public @interface RubricItem {
        String category();
        String description();
        int value();
    }

    //Begin Sequential Searcher Tests
    @RubricItem(category = "indexOf", description = "empty array returns -1", value = 1)
    @Test
    public void testIndexOfISSEmpty() {
        int[] arr = {};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(-1, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "singleton array returns 0 if there", value = 1)
    @Test
    public void testIndexOfISSOneFound() {
        int[] arr = {1};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(0, s.indexOf(1));
    }

    @RubricItem(category = "indexOf", description = "singleton array returns -1 if not there", value = 1)
    @Test
    public void testIndexOfISSOneNotFound() {
        int[] arr = {1};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(-1, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "array of two elements can return second index", value = 1)
    @Test
    public void testIndexOfISSTwoFound() {
        int[] arr = {1, 2};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(1, s.indexOf(2));
    }

    @RubricItem(category = "indexOf", description = "array of two elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfISSTwoNotFound() {
        int[] arr = {1, 2};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(-1, s.indexOf(3));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns 0 for first item", value = 1)
    @Test
    public void testIndexOfISSManyFoundBeginning() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(0, s.indexOf(0));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns middle for middle item", value = 1)
    @Test
    public void testIndexOfISSManyFoundMiddle() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(50, s.indexOf(50));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns last index for last item", value = 1)
    @Test
    public void testIndexOfISSManyFoundEnd() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(99, s.indexOf(99));
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns each index for each item", value = 1)
    @Test
    public void testIndexOfISSManyFoundAll() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, s.indexOf(i));
        }
    }

    @RubricItem(category = "indexOf", description = "array of many elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfISSManyNotFound() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertEquals(-1, s.indexOf(100));
    }

    //Begin Sequential Searcher Contains Tests
    @RubricItem(category = "contains", description = "empty array returns false", value = 1)
    @Test
    public void testContainsISSEmptyFalse() {
        int[] arr = {};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertFalse(s.contains(0));
    }

    @RubricItem(category = "contains", description = "returns true for first item", value = 1)
    @Test
    public void testContainsISSBeginning() {
        int[] arr = {-1,-2,-3};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertTrue(s.contains(-1));
    }

    @RubricItem(category = "contains", description = "returns true for middle item", value = 1)
    @Test
    public void testContainsISSMiddle() {
        int[] arr = {-1,-2,-3};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertTrue(s.contains(-2));
    }

    @RubricItem(category = "contains", description = "returns true for last item", value = 1)
    @Test
    public void testContainsISSEnd() {
        int[] arr = {-1,-2,-3};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertTrue(s.contains(-3));
    }

    @RubricItem(category = "contains", description = "returns false for item not in list", value = 1)
    @Test
    public void testContainsISSFalse() {
        int[] arr = {-1,-2,-3};
        Searcher s = new IntSequentialSearcher(arr);
        Assert.assertFalse(s.contains(1));
    }

    @RubricItem(category = "contains", description = "returns true for many items in a list", value = 1)
    @Test
    public void testContainsISSManyTrue() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        for (int i = 0; i < 200; i += 2) {
            Assert.assertTrue(s.contains(i));
        }
    }

    @RubricItem(category = "contains", description = "returns false for many items not in a list", value = 1)
    @Test
    public void testContainsISSManyFalse() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i;
        }
        Searcher s = new IntSequentialSearcher(arr);
        for (int i = 1; i < 202; i += 2) {
            Assert.assertFalse(s.contains(i));
        }
    }
/*
    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntSequentialSearcherTests.class, 240);
    }
*/
}
