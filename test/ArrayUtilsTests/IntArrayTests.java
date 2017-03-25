package ArrayUtilsTests;

import org.junit.Assert;
import org.junit.Test;
import tools.ArrayUtils;
import gradeit.*;

import RubricInterface.*;

/**
 * Created by daackerman on 3/17/2017.
 */
public class IntArrayTests extends GradeItTest {
    @RubricItem(category = "isSorted", description = "empty list", value = 1)
    @Test
    public void testIAIsSortedEmpty() {
        int[] a = {};
        Assert.assertTrue(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "singleton list", value = 1)
    @Test
    public void testIAIsSortedOne() {
        int[] a = {1};
        Assert.assertTrue(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "sorted list of two", value = 1)
    @Test
    public void testIAIsSortedTwoTrue() {
        int[] a = {1,2};
        Assert.assertTrue(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "unsorted list of two", value = 1)
    @Test
    public void testIAIsSortedTwoFalse() {
        int[] a = {2,1};
        Assert.assertFalse(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "sorted list of many", value = 1)
    @Test
    public void testIAIsSortedManyTrue() {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i;
        }
        Assert.assertTrue(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "reverse sorted list of many", value = 1)
    @Test
    public void testIAIsSortedReverseFalse() {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = 99 - i;
        }
        Assert.assertFalse(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "isSorted", description = "almost sorted list of many", value = 1)
    @Test
    public void testIAIsSortedManyAlmostTrue() {
        int[] a = new int[100];
        for (int i = 0; i < 99; i++) {
            a[i] = i;
        }
        a[99] = 0;
        Assert.assertFalse(ArrayUtils.isSorted(a));
    }

    @RubricItem(category = "swap", description = "itself small list", value = 1)
    @Test
    public void testIASwapItself() {
        int[] a = {1};
        ArrayUtils.swap(a,0,0);
        Assert.assertArrayEquals(new int[]{1}, a);
    }

    @RubricItem(category = "swap", description = "two elements small list", value = 1)
    @Test
    public void testIASwapSimple() {
        int[] a = {1,2};
        ArrayUtils.swap(a,0,1);
        Assert.assertArrayEquals(new int[]{2,1}, a);
    }

    @RubricItem(category = "swap", description = "two elements close larger list", value = 1)
    @Test
    public void testIASwapFarther() {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        ArrayUtils.swap(a,3,4);
        Assert.assertArrayEquals(new int[]{1,2,3,5,4,6,7,8,9,10}, a);
    }

    @RubricItem(category = "swap", description = "two elements far larger list", value = 1)
    @Test
    public void testIASwapFirstAndLast() {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        ArrayUtils.swap(a,0,9);
        Assert.assertArrayEquals(new int[]{10,2,3,4,5,6,7,8,9,1}, a);
    }

    @RubricItem(category = "swap", description = "throws exception for too large indexes", value = 1)
    @Test
    public void testIASwapInvalidLarge() {
        boolean exceptionThrown = false;
        int[] a = {1,2,3};
        try {
            ArrayUtils.swap(a, 1, 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    @RubricItem(category = "swap", description = "throws exception for too small indexes", value = 1)
    @Test
    public void testIASwapInvalidNegative() {
        boolean exceptionThrown = false;
        int[] a = {1,2,3};
        try {
            ArrayUtils.swap(a, -1, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    @RubricItem(category = "swap", description = "throws exception on empty list", value = 1)
    @Test
    public void testIASwapInvalidEmpty() {
        boolean exceptionThrown = false;
        int[] a = {};
        try {
            ArrayUtils.swap(a, 0, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(IntArrayTests.class, 100);
    }
}
